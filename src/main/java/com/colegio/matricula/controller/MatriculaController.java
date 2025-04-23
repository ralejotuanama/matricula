package com.colegio.matricula.controller;

import com.colegio.matricula.model.Matricula;
import com.colegio.matricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @PostMapping
    public String guardar(@RequestBody Matricula matricula) {
        service.guardar(matricula);
        return "Alumno matriculado";
    }

    @GetMapping
    public List<Matricula> listar() {
        return service.listar();
    }


}
