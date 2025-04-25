package com.colegio.matricula.repository;


import com.colegio.matricula.errores.RegistroDuplicadoException;
import com.colegio.matricula.errores.RegistroInvalidoException;
import com.colegio.matricula.model.Periodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeriodoRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void guardar(Periodo periodo) {

        try {
            jdbc.update("INSERT INTO periodo(nombre, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?)",
                    periodo.getNombre(), periodo.getFechaInicio(), periodo.getFechaFin(), periodo.getEstado());
        } catch (Exception e) {
            throw new RegistroDuplicadoException("nombre");
        }
         }

    public List<Periodo> listar() {
        return jdbc.query("SELECT * FROM periodo", new BeanPropertyRowMapper<>(Periodo.class));
    }

    public Periodo obtenerPorId(Long id) {
        try {
            return jdbc.queryForObject("SELECT * FROM periodo WHERE id = ?",
                    new BeanPropertyRowMapper<>(Periodo.class), id);
        } catch (Exception e) {
            return null;
        }
    }

}
