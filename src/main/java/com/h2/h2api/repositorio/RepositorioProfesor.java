package com.h2.h2api.repositorio;

import com.h2.h2api.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProfesor extends JpaRepository<Profesor, Integer> {
}
