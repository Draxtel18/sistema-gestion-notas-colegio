package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.infraestructure.persistence.entity.AlumnoEntity;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepositoryJPA extends JpaRepository<CursoEntity, Long> {
    Optional<CursoEntity> findById(Long id);
}
