package com.example.weatherapi.exception;

public class InSufficientDataException extends Exception{
    public InSufficientDataException() {
    }

    public InSufficientDataException(String message) {
        super(message);
    }
}
