package com.colegio.matricula.model;

public class Docente {


    private Long id;
    private String nombre;
    private String especialidad;
    private String email;

    public Docente() {
    }




    public Docente(Long id, String nombre, String especialidad, String email) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.email = email;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Docente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
