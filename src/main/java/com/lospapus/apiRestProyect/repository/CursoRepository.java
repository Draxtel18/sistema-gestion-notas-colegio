package com.lospapus.apiRestProyect.repository;

import com.lospapus.apiRestProyect.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
