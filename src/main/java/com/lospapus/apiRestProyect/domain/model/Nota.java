package com.lospapus.apiRestProyect.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Nota {
    private Long id;
    private Alumno alumno;
    private Curso curso;
    private Double notaValor;
    private String comentarios;
    private LocalDate fechaNota;

    public Nota(Alumno alumno, Curso curso, Double notaValor, String comentarios, LocalDate fechaNota) {
        this.alumno = alumno;
        this.curso = curso;
        this.notaValor = notaValor;
        this.comentarios = comentarios;
        this.fechaNota = fechaNota;
    }

    public Nota(Alumno alumno, Curso curso, Double notaValor, LocalDate fechaNota) {
        this.alumno = alumno;
        this.curso = curso;
        this.notaValor = notaValor;
        this.fechaNota = fechaNota;
    }

    public void actualizarNota(double nuevaNota, String nuevoComentario) {
        validarNota(nuevaNota);
        this.notaValor = nuevaNota;
        this.comentarios = nuevoComentario;
    }

    public void añadirComentario(String comentario) {
        if (this.comentarios == null) {
            this.comentarios = comentario;
        } else {
            this.comentarios += "\n" + comentario;
        }
    }

    private void validarNota(double nota) {
        if (nota < 0.0 || nota > 20.0) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 20.");
        }
    }
}
