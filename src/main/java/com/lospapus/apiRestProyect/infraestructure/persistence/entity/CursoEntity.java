package com.lospapus.apiRestProyect.infraestructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "cursos")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String anioEscolar;

    @Column(nullable = false)
    private String aula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesorEntity")
    private ProfesorEntity profesor;

    @OneToMany(mappedBy = "cursoEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InscripcionEntity> inscripciones = new ArrayList<>();

    @OneToMany(mappedBy = "cursoEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NotaEntity> notaEntities = new ArrayList<>();

    public CursoEntity(int id, String name, String anioEscolar, String aula) {
        this.id = id;
        this.name = name;
        this.anioEscolar = anioEscolar;
        this.aula = aula;
    }
}
