package com.lospapus.apiRestProyect.domain.repository;

import com.lospapus.apiRestProyect.domain.model.Asignaciones;

import java.util.Optional;


public interface AsignacionesRepository {
    Optional<Asignaciones> buscarPorId(int id);
}
