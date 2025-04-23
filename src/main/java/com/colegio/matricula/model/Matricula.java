package com.colegio.matricula.model;

public class Matricula {

    private Long id;
    private Long alumnoId;
    private Long cursoId;
    // Getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }


    public Matricula(Long id, Long alumnoId, Long cursoId) {
        this.id = id;
        this.alumnoId = alumnoId;
        this.cursoId = cursoId;
    }

    public Matricula() {
    }



    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", alumnoId=" + alumnoId +
                ", cursoId=" + cursoId +
                '}';
    }



}
