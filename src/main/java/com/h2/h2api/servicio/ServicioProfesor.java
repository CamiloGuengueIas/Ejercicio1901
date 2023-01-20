package com.h2.h2api.servicio;

import com.h2.h2api.modelo.Profesor;

import java.util.Optional;

public interface ServicioProfesor {
    Profesor guardarProfesor(Profesor profesor);
    Profesor obtenerProfesor(int idProfesor);

    Profesor profesorModificar(int id,Profesor profesorModificar);

    boolean eliminarProfesor(int id);
}