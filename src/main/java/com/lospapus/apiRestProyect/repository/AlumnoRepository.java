package com.lospapus.apiRestProyect.repository;

import com.lospapus.apiRestProyect.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}
