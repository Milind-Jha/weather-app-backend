package com.example.weatherapi.util;

import java.util.UUID;

public class RandomClientCredentialsGenerator {
    public static String generateClientId() {
        return UUID.randomUUID().toString();
    }

    public static String generateClientSecret() {
        return UUID.randomUUID().toString();
    }
}

