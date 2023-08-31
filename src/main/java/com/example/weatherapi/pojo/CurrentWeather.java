package com.example.weatherapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CurrentWeather {
    @JsonProperty("last_updated_epoch")
    private long lastUpdatedEpoch;

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("temp_c")
    private double temperatureCelsius;

    @JsonProperty("temp_f")
    private double temperatureFahrenheit;

    @JsonProperty("is_day")
    private int isDay;

    @JsonProperty("condition")
    private Condition condition;


}
