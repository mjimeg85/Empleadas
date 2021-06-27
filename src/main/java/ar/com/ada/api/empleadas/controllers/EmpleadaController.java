package ar.com.ada.api.empleadas.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.empleadas.entities.Empleada;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.services.EmpleadaService;

@RestController
public class EmpleadaController {

    @Autowired
    private EmpleadaService service;

    @PostMapping("/empleados")
    public ResponseEntity<?> crearEmpleada(@RequestBody Empleada empleada) { // ningun web method devuelve un void

        GenericResponse respuesta = new GenericResponse();

        service.crearEmpleada(empleada);

        respuesta.isOk = true;
        respuesta.id = empleada.getEmpleadaId();
        respuesta.message = "La empleada fue añadida con éxito";

        return ResponseEntity.ok(respuesta);

    }

    // GET /empleadas
    @GetMapping("/empleados") // hacer el mapping
    public ResponseEntity<List<Empleada>> traerEmpleada() { // return Responde Entity
        return ResponseEntity.ok(service.traerEmpleada()); // return entity con el valor esperado

    }

}
