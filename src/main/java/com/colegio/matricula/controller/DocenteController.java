package com.colegio.matricula.controller;

import com.colegio.matricula.errores.RecursoNoEncontradoException;
import com.colegio.matricula.errores.RegistroDuplicadoException;
import com.colegio.matricula.model.CommonResponse;
import com.colegio.matricula.model.Docente;
import com.colegio.matricula.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {


    @Autowired
    private DocenteService service;

    @PostMapping
    public ResponseEntity<CommonResponse> guardar(@RequestBody Docente docente) {

        try {
            service.guardar(docente);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new CommonResponse("201", "Docente registrado"));
        } catch (RegistroDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new CommonResponse("409", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Docente>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> obtener(@PathVariable Long id) {
        try {
            Docente docente = service.obtener(id);
            return ResponseEntity.ok(new CommonResponse("200", "Docente encontrado"));
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CommonResponse("404", e.getMessage()));
        }
    }

}
