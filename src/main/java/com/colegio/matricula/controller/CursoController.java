package com.colegio.matricula.controller;

import com.colegio.matricula.model.CommonResponse;
import com.colegio.matricula.model.Curso;
import com.colegio.matricula.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    public ResponseEntity<CommonResponse> guardar(@RequestBody Curso curso) {
        service.guardar(curso);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CommonResponse("201", "Curso Registrado"));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Curso> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> obtener(@PathVariable Long id) {
        Curso curso = service.obtener(id);
        if(curso == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CommonResponse("404", "Curso no encontrado"));
        }
        return ResponseEntity.ok(new CommonResponse("201", "Curso Regsitrado"));
    }


}
