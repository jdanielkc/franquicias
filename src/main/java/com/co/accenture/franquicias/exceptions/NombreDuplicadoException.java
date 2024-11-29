package com.co.accenture.franquicias.exceptions;

/**
 * Clase que representa una excepción personalizada para duplicidad de franquicias
 * 
 * @version 1.0
 * @autor Daniel Garcia
 * @since 2024/11/28
 */
public class NombreDuplicadoException extends RuntimeException {
    private String message2;

    public NombreDuplicadoException(String message, String message2) {
        super(message);
        this.message2 = message2;
    }

    public NombreDuplicadoException() {
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

}
