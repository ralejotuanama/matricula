package com.colegio.matricula.repository;

import com.colegio.matricula.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnoRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public int guardar(Alumno a) {
        return jdbc.update("INSERT INTO alumno(nombre, email) VALUES (?, ?)",
                a.getNombre(), a.getEmail());
    }

    public List<Alumno> listar() {
        return jdbc.query("SELECT * FROM alumno", new BeanPropertyRowMapper<>(Alumno.class));
    }

    public Alumno obtenerPorId(Long id) {
        return jdbc.queryForObject("SELECT * FROM alumno WHERE id=?",
                new BeanPropertyRowMapper<>(Alumno.class), id);
    }
}
