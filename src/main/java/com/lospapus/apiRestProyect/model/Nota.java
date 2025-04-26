package com.lospapus.apiRestProyect.model;

import lombok.*;

@NoArgsConstructor
@ToString
public class Nota {
    private int id;
    private double valor;
    private Alumno alumno;
    private Curso curso;

    public Nota(int id, double valor, Alumno alumno, Curso curso) {
        this.id = id;
        this.valor = valor;
        this.alumno = alumno;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public com.lospapus.apiRestProyect.model.Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(com.lospapus.apiRestProyect.model.Alumno alumno) {
        this.alumno = alumno;
    }

    public com.lospapus.apiRestProyect.model.Curso getCurso() {
        return curso;
    }

    public void setCurso(com.lospapus.apiRestProyect.model.Curso curso) {
        this.curso = curso;
    }
}
