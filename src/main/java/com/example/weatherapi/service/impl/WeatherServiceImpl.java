package com.example.weatherapi.service.impl;


import com.example.weatherapi.pojo.Weather;
import com.example.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${rapidapi.host}")
    private String rapidApiHost;

    @Value("${rapidapi.key}")
    private String rapidApiKey;

    @Autowired
    private RestTemplate  restTemplate;


    @Override
    public Weather getDetails (String city, String country) {
        String apiUrl = "https://weatherapi-com.p.rapidapi.com/current.json?q=" + city + "%2C" + country;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", rapidApiHost);
        headers.set("X-RapidAPI-Key", rapidApiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Weather> response = new RestTemplate()
                .exchange(apiUrl, HttpMethod.GET, entity, Weather.class);

        ResponseEntity<Object> response2 = restTemplate.exchange(apiUrl,
                HttpMethod.GET, entity, Object.class);

        LinkedHashMap<String,Object> body = (LinkedHashMap<String,Object>) response2.getBody();
        Map<String, Object> currentMap = (Map<String, Object>) body.get("current");


        if (response.getStatusCode() == HttpStatus.OK) {
            Weather weather = response.getBody();
            weather.setWindMph((double) currentMap.get("wind_mph"));
            weather.setWindKph((double) currentMap.get("wind_kph"));
            weather.setWindDegree((int) currentMap.get("wind_degree"));
            weather.setWindDirection((String) currentMap.get("wind_dir"));
            weather.setPressureMb((double) currentMap.get("pressure_mb"));
            weather.setPressureIn((double) currentMap.get("pressure_in"));
            weather.setPrecipitationMm((double) currentMap.get("precip_mm"));
            weather.setPrecipitationIn((double) currentMap.get("precip_in"));
            weather.setHumidity((int) currentMap.get("humidity"));
            weather.setCloud((int) currentMap.get("cloud"));
            weather.setFeelsLikeCelsius((double) currentMap.get("feelslike_c"));
            weather.setFeelsLikeFahrenheit((double) currentMap.get("feelslike_f"));
            weather.setVisibilityKm((double) currentMap.get("vis_km"));
            weather.setVisibilityMiles((double) currentMap.get("vis_miles"));
            weather.setUvIndex((double) currentMap.get("uv"));
            weather.setGustMph((double) currentMap.get("gust_mph"));
            weather.setGustKph((double) currentMap.get("gust_kph"));
            return weather;
        }
        return null;
    }


}
