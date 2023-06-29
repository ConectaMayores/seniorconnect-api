package com.conectamayores.seniorconnectapi.exceptions;

public class ContraseñaInvalidaException  extends RuntimeException{

    public ContraseñaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
