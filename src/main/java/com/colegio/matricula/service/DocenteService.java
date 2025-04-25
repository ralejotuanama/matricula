package com.colegio.matricula.service;

import com.colegio.matricula.errores.RecursoNoEncontradoException;
import com.colegio.matricula.model.Docente;
import com.colegio.matricula.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {


    @Autowired
    private DocenteRepository repo;

    public void guardar(Docente docente) {
        repo.guardar(docente);
    }

    public List<Docente> listar() {
        return repo.listar();
    }

    public Docente obtener(Long id) {
        Docente docente = repo.obtenerPorId(id);
        if (docente == null) {
            throw new RecursoNoEncontradoException(id);
        }
        return docente;
    }
}
