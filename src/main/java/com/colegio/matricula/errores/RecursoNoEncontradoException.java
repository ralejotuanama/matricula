package com.colegio.matricula.errores;

public class RecursoNoEncontradoException extends RuntimeException{

    public RecursoNoEncontradoException( Long id) {
        super("registro con ID " + id + " no fue encontrado");
    }


}
