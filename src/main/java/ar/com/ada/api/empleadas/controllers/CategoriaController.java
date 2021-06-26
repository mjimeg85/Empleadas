package ar.com.ada.api.empleadas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.empleadas.entities.*;
import ar.com.ada.api.empleadas.models.response.*;
import ar.com.ada.api.empleadas.services.*;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping("/categorias") 
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){ //ningun web method devuelve un void
        
        GenericResponse respuesta = new GenericResponse;

        service.crearCategoria(categoria);

        respuesta.isOk= true;
        respuesta.id=categoria.getCategoriaId();
        respuesta.message="La categoría fue creada con éxito";

        return ResponseEntity.ok(respuesta);

    }

    //GET /categorias
    @GetMapping("/categorias") //hacer el mapping
    public ResponseEntity<List<Categoria>> traerCategoria(){ //return Responde Entity
        return ResponseEntity.ok(service.traerCategoria()); //return entity con el valor esperado

    }
    
}
