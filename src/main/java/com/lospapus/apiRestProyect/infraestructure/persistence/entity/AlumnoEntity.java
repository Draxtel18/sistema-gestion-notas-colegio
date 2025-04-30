package com.lospapus.apiRestProyect.infraestructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "alumnos")
public class AlumnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String direccion;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private LocalDate fechaRegistro;

    @Column(nullable = false)
    private boolean active = true;

    @OneToMany(mappedBy = "alumnoEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InscripcionEntity> inscripciones = new ArrayList<>();

    @OneToMany(mappedBy = "alumnoEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NotaEntity> notaEntities = new ArrayList<>();

    public AlumnoEntity(Long id, String name, String direccion, String telefono, String email, Date fechaNacimiento, LocalDate fechaRegistro, boolean active) {
        this.id = id;
        this.name = name;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.active = active;
    }

    public AlumnoEntity(String name, String direccion, String telefono, String email, Date fechaNacimiento) {
        this.name = name;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }
}


