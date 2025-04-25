package com.colegio.matricula.controller;

import com.colegio.matricula.model.CommonResponse;
import com.colegio.matricula.model.Matricula;
import com.colegio.matricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @PostMapping
    public ResponseEntity<CommonResponse> guardar(@RequestBody Matricula matricula) {
        service.guardar(matricula);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CommonResponse("201", "Alumno matriculado"));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Matricula> matriculas = service.listar();
        return ResponseEntity.ok(matriculas);
    }


}
