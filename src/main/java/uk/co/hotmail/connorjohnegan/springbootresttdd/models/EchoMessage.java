package uk.co.hotmail.connorjohnegan.springbootresttdd.models;

public class EchoMessage {
    private String message;

    public EchoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
