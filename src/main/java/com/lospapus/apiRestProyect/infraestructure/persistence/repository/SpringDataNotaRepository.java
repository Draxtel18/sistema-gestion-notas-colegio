package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.infraestructure.persistence.entity.NotaEntity;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface SpringDataNotaRepository extends JpaRepository<NotaEntity, Integer> {
    Optional<NotaEntity> findById(int id);
}
