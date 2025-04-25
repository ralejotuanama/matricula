package com.colegio.matricula.controller;

import com.colegio.matricula.errores.RecursoNoEncontradoException;
import com.colegio.matricula.errores.RegistroDuplicadoException;
import com.colegio.matricula.errores.RegistroInvalidoException;
import com.colegio.matricula.model.CommonResponse;
import com.colegio.matricula.model.Horario;
import com.colegio.matricula.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService service;

    @PostMapping
    public ResponseEntity<CommonResponse> guardar(@RequestBody Horario horario) {
        try {
            service.guardar(horario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new CommonResponse("201", "Horario registrado"));
        } catch (RegistroDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new CommonResponse("409", e.getMessage()));
        }catch (RegistroInvalidoException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new CommonResponse("409", ex.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Horario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> obtener(@PathVariable Long id) {
        try {
            Horario horario = service.obtener(id);
            return ResponseEntity.ok(new CommonResponse("200", "Horario encontrado"));
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CommonResponse("404", e.getMessage()));
        }
    }

}
