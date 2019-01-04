package domain.exceptions;

public class NameException extends Exception{
    private String customMessage;

    public NameException(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    @Override
    public String toString() {
        return "NameException{" +
                "customMessage='" + customMessage + '\'' +
                '}';
    }
}
