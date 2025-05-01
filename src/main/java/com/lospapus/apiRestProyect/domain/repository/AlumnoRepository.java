package com.lospapus.apiRestProyect.domain.repository;

import com.lospapus.apiRestProyect.domain.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoRepository {
    Alumno save(Alumno alumno);
    Optional<Alumno> findById(Long id);
    Optional<Alumno> findByEmail(String email);
    List<Alumno> findAll();
}
