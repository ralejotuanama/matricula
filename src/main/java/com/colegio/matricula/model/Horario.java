package com.colegio.matricula.model;

public class Horario {


    private Long id;
    private Long cursoId;
    private String dia;



    private String horaInicio;
    private String horaFin;
    private String aula;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Horario() {
    }


    public Horario(Long id, Long cursoId, String dia, String horaInicio, String horaFin, String aula) {
        this.id = id;
        this.cursoId = cursoId;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aula = aula;
    }


    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", cursoId=" + cursoId +
                ", dia='" + dia + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", aula='" + aula + '\'' +
                '}';
    }

}
