package com.example.weatherapi.controller;

import com.example.weatherapi.exception.InSufficientDataException;
import com.example.weatherapi.pojo.Weather;
import com.example.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @GetMapping("/check")
    public String check(){
        return "ok";
    }

    @GetMapping("/forecast-summary")
    public Weather getForcast(@RequestParam String city, @RequestParam String country)
            throws InSufficientDataException {
        return weatherService.getDetails(city , country);
    }



}
