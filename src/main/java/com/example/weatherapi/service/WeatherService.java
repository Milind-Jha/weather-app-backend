package com.example.weatherapi.service;

import com.example.weatherapi.exception.InSufficientDataException;
import com.example.weatherapi.pojo.Weather;

public interface WeatherService {
    public Weather getDetails(String city, String country);
}
