package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.infraestructure.persistence.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataInscripcionRepository extends JpaRepository<InscripcionEntity, Integer> {
    List<InscripcionEntity> findByAlumnoId(int id);

    Optional<InscripcionEntity> findByAlumnoIdAndCursoEntityId(int alumnoId, int cursoId);

    @Query("SELECT n FROM InscripcionEntity n WHERE n.cursoEntity.nombreAula = :nombreAula")
    List<NotaEntity> obtenerInscripcionesPorCurso(@Param("nombreAula") String nombreAula);

    @Query("SELECT n FROM InscripcionEntity n WHERE n.alumno.dni = :nombreAula")
    List<AsignacionesEntity> obtenerInscripcionesPorAlumno(@Param("nombreAula") String dni);
}
