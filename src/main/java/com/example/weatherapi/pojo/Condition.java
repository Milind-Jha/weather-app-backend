package com.example.weatherapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Condition {
    @JsonProperty("text")
    private String text;

    @JsonProperty("icon")
    private String iconUrl;

    @JsonProperty("code")
    private int code;

}
