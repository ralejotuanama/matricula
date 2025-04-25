package com.colegio.matricula.repository;

import com.colegio.matricula.errores.RegistroDuplicadoException;
import com.colegio.matricula.errores.RegistroInvalidoException;
import com.colegio.matricula.model.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HorarioRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void guardar(Horario horario) {
        try {
            jdbc.update("INSERT INTO horario(curso_id, dia, hora_inicio, hora_fin, aula) VALUES (?, ?, ?, ?, ?)",
                    horario.getCursoId(), horario.getDia(), horario.getHoraInicio(), horario.getHoraFin(), horario.getAula());
        } catch (DuplicateKeyException e) {
            throw new RegistroDuplicadoException("horario");
        }catch (Exception ex){
            throw new RegistroInvalidoException("horario");
        }
    }

    public List<Horario> listar() {
        return jdbc.query("SELECT * FROM horario", new BeanPropertyRowMapper<>(Horario.class));
    }

    public Horario obtenerPorId(Long id) {
        try {
            return jdbc.queryForObject("SELECT * FROM horario WHERE id = ?",
                    new BeanPropertyRowMapper<>(Horario.class), id);
        } catch (Exception e) {
            return null;
        }
    }


}
