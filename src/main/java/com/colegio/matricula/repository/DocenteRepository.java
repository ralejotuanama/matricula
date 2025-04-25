package com.colegio.matricula.repository;

import com.colegio.matricula.errores.RegistroDuplicadoException;
import com.colegio.matricula.model.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocenteRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void guardar(Docente docente) {
        try {
            jdbc.update("INSERT INTO docente(nombre, especialidad, email) VALUES (?, ?, ?)",
                    docente.getNombre(), docente.getEspecialidad(), docente.getEmail());
        } catch (Exception e) {
            throw new RegistroDuplicadoException("correo");
        }
    }

    public List<Docente> listar() {
        return jdbc.query("SELECT * FROM docente",
                new BeanPropertyRowMapper<>(Docente.class));
    }

    public Docente obtenerPorId(Long id) {
        try {
            return jdbc.queryForObject("SELECT * FROM docente WHERE id = ?",
                    new BeanPropertyRowMapper<>(Docente.class), id);
        } catch (Exception e) {
            return null;
        }
    }

}
