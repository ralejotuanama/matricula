package com.colegio.matricula.service;

import com.colegio.matricula.model.Alumno;
import com.colegio.matricula.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService
{

    @Autowired
    private AlumnoRepository repo;

    public void guardar(Alumno a) {
        repo.guardar(a);
    }

    public List<Alumno> listar() {
        return repo.listar();
    }

    public Alumno obtener(Long id) {
        return repo.obtenerPorId(id);
    }
}
