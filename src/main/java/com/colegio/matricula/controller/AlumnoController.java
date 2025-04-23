package com.colegio.matricula.controller;


import com.colegio.matricula.model.Alumno;
import com.colegio.matricula.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @PostMapping
    public String guardar(@RequestBody Alumno alumno) {
        service.guardar(alumno);
        return "Alumno registrado";
    }

    @GetMapping
    public List<Alumno> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Alumno obtener(@PathVariable Long id) {
        return service.obtener(id);
    }


}
