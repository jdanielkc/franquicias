package com.co.accenture.franquicias.exceptions;

public class FranquiciaDuplicadaException extends RuntimeException {
    private String message2;

    public FranquiciaDuplicadaException(String message, String message2) {
        super(message);
        this.message2 = message2;
    }

    public FranquiciaDuplicadaException() {
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

}
