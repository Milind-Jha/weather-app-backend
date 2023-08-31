package com.example.weatherapi.config;

import com.example.weatherapi.util.RandomClientCredentialsGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private String generatedClientId = RandomClientCredentialsGenerator.generateClientId();
    private String generatedClientSecret = RandomClientCredentialsGenerator.generateClientSecret();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/weather/**").authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(basicAuthenticationPoint());
    }

    @Bean
    public AuthenticationEntryPoint basicAuthenticationPoint() {
        return new BasicAuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
                response.addHeader("WWW-Authenticate", "Basic realm=\"Weather API\"");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
            }

            // Set the realmName
            @Override
            public void afterPropertiesSet() {
                setRealmName("Weather API");
                super.afterPropertiesSet();
            }
        };
    }


    @Bean
    public UserDetailsService userDetailsService() {
        String generatedClientId = RandomClientCredentialsGenerator.generateClientId();
        String generatedClientSecret = RandomClientCredentialsGenerator.generateClientSecret();

        System.out.println("Generated Client ID: " + generatedClientId);
        System.out.println("Generated Client Secret: " + generatedClientSecret);

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername(generatedClientId)
                        .password("{noop}" + generatedClientSecret)
                        .roles("USER")
                        .build()
        );
        return manager;
    }
}
