package com.colegio.matricula.errores;

public class RegistroInvalidoException extends RuntimeException{
    public RegistroInvalidoException(String mensaje) {
        super("error al ingresar " + mensaje);
    }
}
