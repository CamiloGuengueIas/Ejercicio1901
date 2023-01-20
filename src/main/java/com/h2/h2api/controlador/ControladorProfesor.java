package com.h2.h2api.controlador;

import com.h2.h2api.modelo.Profesor;
import com.h2.h2api.servicio.ServicioProfesor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesores")
@RequiredArgsConstructor
public class ControladorProfesor {
    private final ServicioProfesor servicioProfesor;

    @PostMapping
    public ResponseEntity guardarProfesor(@RequestBody Profesor profesor){
        return new ResponseEntity(servicioProfesor.guardarProfesor(profesor), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity obtenerProfesor ( @PathVariable("id") int idProfesor){
        return new ResponseEntity(servicioProfesor.obtenerProfesor(idProfesor), HttpStatus.OK);
        }
    @PutMapping("/{id}")
    public ResponseEntity guardarProfesor(@PathVariable("id") int idProfesor, @RequestBody Profesor profesor) {
        return new ResponseEntity(servicioProfesor.profesorModificar(idProfesor, profesor), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarProfesor(@PathVariable("id") int idProfesor, @RequestBody Profesor profesor) {
        boolean respuesta = servicioProfesor.eliminarProfesor(idProfesor);
        if(respuesta == true){
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
