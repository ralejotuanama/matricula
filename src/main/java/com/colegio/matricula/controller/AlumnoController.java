package com.colegio.matricula.controller;


import com.colegio.matricula.model.Alumno;
import com.colegio.matricula.model.CommonResponse;
import com.colegio.matricula.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @PostMapping
    public ResponseEntity<CommonResponse> guardar(@RequestBody Alumno alumno) {
        service.guardar(alumno);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CommonResponse("201","Alumno Registrado"));
    }

    @GetMapping
    public ResponseEntity<?> listar() {

        List<Alumno> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> obtener(@PathVariable Long id) {

        Alumno alumno = service.obtener(id);
       if(alumno == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body(new CommonResponse("404", "Alumno no encontrado"));
       }

       return  ResponseEntity.ok(new CommonResponse("200", "Alumno encontrado"));
    }


}
