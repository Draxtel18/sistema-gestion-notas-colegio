package com.lospapus.apiRestProyect.repository;

import com.lospapus.apiRestProyect.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    @Query("SELECT n FROM Nota n WHERE n.alumno.id = :alumnoId")
    List<Nota> findNotasByAlumnoId(@Param("alumnoId") int alumnoId);
}
