package com.example.weatherapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Getter
public class Weather {

        @JsonProperty("location")
        private Location location;

        @JsonProperty("current")
        private CurrentWeather current;

        @JsonProperty("wind_mph")
        private double windMph;

        @JsonProperty("wind_kph")
        private double windKph;

        @JsonProperty("wind_degree")
        private int windDegree;

        @JsonProperty("wind_dir")
        private String windDirection;

        @JsonProperty("pressure_mb")
        private double pressureMb;

        @JsonProperty("pressure_in")
        private double pressureIn;

        @JsonProperty("precip_mm")
        private double precipitationMm;

        @JsonProperty("precip_in")
        private double precipitationIn;

        @JsonProperty("humidity")
        private int humidity;

        @JsonProperty("cloud")
        private int cloud;

        @JsonProperty("feelslike_c")
        private double feelsLikeCelsius;

        @JsonProperty("feelslike_f")
        private double feelsLikeFahrenheit;

        @JsonProperty("vis_km")
        private double visibilityKm;

        @JsonProperty("vis_miles")
        private double visibilityMiles;

        @JsonProperty("uv")
        private double uvIndex;

        @JsonProperty("gust_mph")
        private double gustMph;

        @JsonProperty("gust_kph")
        private double gustKph;

        // Getters and setters
}
