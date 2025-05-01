package com.lospapus.apiRestProyect.domain.repository;

import com.lospapus.apiRestProyect.domain.model.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorRepository {
    Profesor save(Profesor profesor);
    Optional<Profesor> findById(Long id);
    List<Profesor> findAll();

}
