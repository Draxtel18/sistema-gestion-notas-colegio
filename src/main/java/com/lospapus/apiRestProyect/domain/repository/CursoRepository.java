package com.lospapus.apiRestProyect.domain.repository;

import com.lospapus.apiRestProyect.domain.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository {
    Curso save(Curso curso);
    Optional<Curso> buscarCursoPorId(int id);
    List<Curso> findAll();
}
