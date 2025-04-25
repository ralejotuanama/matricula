package com.colegio.matricula.repository;

import com.colegio.matricula.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CursoRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public int guardar(Curso c) {
        return jdbc.update("INSERT INTO curso(nombre, descripcion) VALUES (?, ?)", c.getNombre(), c.getDescripcion());
    }

    public List<Curso> listar() {
        return jdbc.query("SELECT * FROM curso", new BeanPropertyRowMapper<>(Curso.class));
    }

    public Curso obtenerPorId(Long id) {
        try {
            return jdbc.queryForObject("SELECT * FROM curso WHERE id = ?", new BeanPropertyRowMapper<>(Curso.class), id);
        } catch (Exception ex){
            return null;
        }
    }
}
