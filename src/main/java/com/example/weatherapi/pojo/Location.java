package com.example.weatherapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Location {

        @JsonProperty("name")
        private String name;

        @JsonProperty("region")
        private String region;

        @JsonProperty("country")
        private String country;

        @JsonProperty("lat")
        private double latitude;

        @JsonProperty("lon")
        private double longitude;

        @JsonProperty("tz_id")
        private String timeZoneId;

        @JsonProperty("localtime_epoch")
        private long localTimeEpoch;

        @JsonProperty("localtime")
        private String localTime;

        // Getters and setters

}
