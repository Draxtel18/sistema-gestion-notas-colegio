package com.lospapus.apiRestProyect.infraestructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "inscripcion")
public class InscripcionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id")
    private AlumnoEntity alumnoEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private CursoEntity cursoEntity;

    @Column(name = "inscripcion_fecha", nullable = false)
    private LocalDate inscripcionFecha;

    public InscripcionEntity(AlumnoEntity alumnoEntity, CursoEntity cursoEntity) {
        this.alumnoEntity = alumnoEntity;
        this.cursoEntity = cursoEntity;
    }
}
