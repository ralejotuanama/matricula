package com.colegio.matricula.controller;

import com.colegio.matricula.errores.RegistroDuplicadoException;
import com.colegio.matricula.errores.RegistroInvalidoException;
import com.colegio.matricula.model.CommonResponse;
import com.colegio.matricula.model.Periodo;
import com.colegio.matricula.service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periodos")
public class PeriodoController {

    @Autowired
    private PeriodoService service;

    @PostMapping
    public ResponseEntity<CommonResponse> guardar(@RequestBody Periodo periodo) {
        try {
            service.guardar(periodo);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new CommonResponse("201", "Periodo registrado"));
        } catch (RegistroDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new CommonResponse("409", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Periodo>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> obtener(@PathVariable Long id) {
        try {
            Periodo periodo = service.obtener(id);
            return ResponseEntity.ok(new CommonResponse("200", "Periodo encontrado"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CommonResponse("404", e.getMessage()));
        }
    }


}
