package com.colegio.matricula.service;

import com.colegio.matricula.errores.RegistroInvalidoException;
import com.colegio.matricula.model.Periodo;
import com.colegio.matricula.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoService {


    @Autowired
    private PeriodoRepository repo;

    public void guardar(Periodo periodo) {
            repo.guardar(periodo);
    }

    public List<Periodo> listar() {
        return repo.listar();
    }

    public Periodo obtener(Long id) {
        Periodo periodo = repo.obtenerPorId(id);
        if (periodo == null) {
            throw new RuntimeException("Periodo con ID " + id + " no encontrado");
        }
        return periodo;
    }
}
