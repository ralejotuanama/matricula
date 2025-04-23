package com.colegio.matricula.controller;

import com.colegio.matricula.model.Curso;
import com.colegio.matricula.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    public String guardar(@RequestBody Curso curso) {
        service.guardar(curso);
        return "Curso registrado";
    }

    @GetMapping
    public List<Curso> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Curso obtener(@PathVariable Long id) {
        return service.obtener(id);
    }


}
