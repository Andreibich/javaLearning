package com.htp.lesson9.hometask9.domain.exceptions;

public class SurNameException extends Exception{
    private String customMessage;

    public SurNameException(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    @Override
    public String toString() {
        return "SurNameException{" +
                "customMessage='" + customMessage + '\'' +
                '}';
    }
}
