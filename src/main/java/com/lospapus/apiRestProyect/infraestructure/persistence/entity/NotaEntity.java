package com.lospapus.apiRestProyect.infraestructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notas")
public class NotaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumnoEntity")
    private AlumnoEntity alumnoEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private CursoEntity cursoEntity;

    @Column(name = "nota")
    private Double notaValor;

    private String comentarios;

    @Column(name = "fecha_nota", nullable = false)
    private LocalDate fechaNota;
}