package com.htp.lesson9.hometask9.exceptions;

public class SexException extends Exception {
    private String customMessage;

    public SexException(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    @Override
    public String toString() {
        return "SexException{" +
                "customMessage='" + customMessage + '\'' +
                '}';
    }
}
