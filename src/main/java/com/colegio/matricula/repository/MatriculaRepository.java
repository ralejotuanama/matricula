package com.colegio.matricula.repository;

import com.colegio.matricula.model.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatriculaRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public int guardar(Matricula m) {
        return jdbc.update("INSERT INTO matricula(alumno_id, curso_id) VALUES (?, ?)", m.getAlumnoId(), m.getCursoId());
    }

    public List<Matricula> listar() {
        return jdbc.query("SELECT * FROM matricula", new BeanPropertyRowMapper<>(Matricula.class));
    }


}
