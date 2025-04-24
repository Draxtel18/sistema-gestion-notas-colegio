package com.lospapus.apiRestProyect.model;

import jakarta.persistence.*;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // GETTERS

    public Long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
