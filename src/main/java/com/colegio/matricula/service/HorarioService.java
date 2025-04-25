package com.colegio.matricula.service;

import com.colegio.matricula.errores.RecursoNoEncontradoException;
import com.colegio.matricula.model.Horario;
import com.colegio.matricula.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository repo;

    public void guardar(Horario horario) {
        repo.guardar(horario);
    }

    public List<Horario> listar() {
        return repo.listar();
    }

    public Horario obtener(Long id) {
        Horario horario = repo.obtenerPorId(id);
        if (horario == null) {
            throw new RecursoNoEncontradoException(id);
        }
        return horario;
    }
}
