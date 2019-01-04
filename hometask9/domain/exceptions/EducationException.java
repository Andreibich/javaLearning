package com.htp.lesson9.hometask9.domain.exceptions;

public class EducationException extends Exception{
    private String customMessage;

    public EducationException(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    @Override
    public String toString() {
        return "EducationException{" +
                "customMessage='" + customMessage + '\'' +
                '}';
    }
}
