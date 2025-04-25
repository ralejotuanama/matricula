package com.colegio.matricula.errores;

public class RegistroDuplicadoException extends RuntimeException{

    public RegistroDuplicadoException(String campo) {
        super("Ya existe un registro con el mismo " + campo);
    }

}
