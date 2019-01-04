package com.htp.lesson9.hometask9.exceptions;

public class AgeException extends Exception{
    private String customMessage;

    public AgeException(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    @Override
    public String toString() {
        return "AgeException{" +
                "customMessage='" + customMessage + '\'' +
                '}';
    }
}
