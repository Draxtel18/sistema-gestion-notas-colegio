package com.lospapus.apiRestProyect.domain.repository;

import com.lospapus.apiRestProyect.application.dto.InscripcionRequestDTO;
import com.lospapus.apiRestProyect.domain.model.Inscripcion;

import java.util.List;
import java.util.Optional;

public interface InscripcionRepository {
    Inscripcion save(Inscripcion inscripcion);
    List<Inscripcion> findByUsuarioId(int usuarioId);
    Optional<Inscripcion> findByUsuarioAndCurso(int usuarioId, int cursoId);
}
