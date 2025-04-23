package com.colegio.matricula.service;

import com.colegio.matricula.model.Curso;
import com.colegio.matricula.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repo;

    public void guardar(Curso c) {
        repo.guardar(c);
    }

    public List<Curso> listar() {
        return repo.listar();
    }

    public Curso obtener(Long id) {
        return repo.obtenerPorId(id);
    }
}
