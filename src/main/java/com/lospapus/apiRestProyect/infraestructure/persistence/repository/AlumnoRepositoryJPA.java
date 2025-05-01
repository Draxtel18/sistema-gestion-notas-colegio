package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.infraestructure.persistence.entity.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepositoryJPA extends JpaRepository<AlumnoEntity, Long>{
    Optional<AlumnoEntity> findById(Long id);
    Optional<AlumnoEntity> findByEmail(String email);
}
