package com.lospapus.apiRestProyect.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class Inscripcion {
    private Integer id;
    private Usuario alumno;
    private Curso curso;
    private LocalDate fechaInscripcion;

    public Inscripcion(Usuario alumno, Curso curso, LocalDate fechaInscripcion) {
        this.alumno = alumno;
        this.curso = curso;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Inscripcion(Integer id, Usuario alumno, Curso curso, LocalDate fechaInscripcion) {
        this.id = id;
        this.alumno = alumno;
        this.curso = curso;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Inscripcion(Usuario alumno, @NotNull(message = "El ID del alumno no puede ser nulo") int idAlumno, @NotNull(message = "El ID del curso no puede ser nulo") int idCurso) {
    }
}
