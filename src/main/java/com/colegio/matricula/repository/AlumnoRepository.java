package com.colegio.matricula.repository;

import com.colegio.matricula.errores.RegistroDuplicadoException;
import com.colegio.matricula.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnoRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void guardar(Alumno alumno) {
        try {
            jdbc.update("INSERT INTO alumno(nombre, email) VALUES (?, ?)",
                    alumno.getNombre(), alumno.getEmail());
        } catch (DuplicateKeyException e) {
            throw new RegistroDuplicadoException("email");
        }
    }

    public List<Alumno> listar() {
        return jdbc.query("SELECT * FROM alumno", new BeanPropertyRowMapper<>(Alumno.class));
    }

    public Alumno obtenerPorId(Long id) {
        try {
            return jdbc.queryForObject("SELECT * FROM alumno WHERE id = ?",
                    new BeanPropertyRowMapper<>(Alumno.class), id);
        } catch (EmptyResultDataAccessException e) {
            return null; // o puedes usar Optional.empty() si prefieres
        }
    }
}
