package com.colegio.matricula.service;

import com.colegio.matricula.model.Matricula;
import com.colegio.matricula.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {


    @Autowired
    private MatriculaRepository repo;

    public void guardar(Matricula m) {
        repo.guardar(m);
    }

    public List<Matricula> listar() {
        return repo.listar();
    }
}
