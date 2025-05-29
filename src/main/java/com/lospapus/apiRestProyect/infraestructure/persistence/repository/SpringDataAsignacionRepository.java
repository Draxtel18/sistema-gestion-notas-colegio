package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.infraestructure.persistence.entity.AsignacionesEntity;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.RolEntity;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataAsignacionRepository extends JpaRepository<AsignacionesEntity, Integer>{
    Optional<AsignacionesEntity> findById(int id);
}
