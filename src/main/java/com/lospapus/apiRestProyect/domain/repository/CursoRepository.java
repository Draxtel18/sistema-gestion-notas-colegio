package com.lospapus.apiRestProyect.domain.repository;

import com.lospapus.apiRestProyect.domain.model.Curso;
import com.lospapus.apiRestProyect.domain.model.Usuario;

import java.util.List;
import java.util.Optional;


public interface CursoRepository {
    List<Curso> findAll();
    Curso save(Curso curso);
    Optional<Curso> findById(int id);
}
