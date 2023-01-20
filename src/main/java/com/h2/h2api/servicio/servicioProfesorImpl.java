package com.h2.h2api.servicio;

import com.h2.h2api.modelo.Profesor;
import com.h2.h2api.repositorio.RepositorioProfesor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class servicioProfesorImpl implements ServicioProfesor{
    private final RepositorioProfesor repositorioProfesor;
    @Override
    public Profesor guardarProfesor(Profesor profesor) {
        return repositorioProfesor.save(profesor);
    }

    @Override
    public Profesor obtenerProfesor(int idProfesor) {
        return repositorioProfesor.findById(idProfesor).orElseThrow(() -> {throw new RuntimeException();});
    }

    @Override
    public Profesor profesorModificar(int id, Profesor profesorModificar) {
        Profesor profesorBuscado = repositorioProfesor.findById(id).get();
        profesorBuscado.setNombre(profesorModificar.getNombre());
        return repositorioProfesor.save(profesorBuscado);
    }

    @Override
    public boolean eliminarProfesor(int id) {
        try {
            repositorioProfesor.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
