package com.lospapus.apiRestProyect.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private int id;
    private String name;
    private String anioEscolar;
    private String aula;
    private Profesor profesor;
    private List<Inscripcion> inscripciones = new ArrayList<>();
    private List<Nota> notas = new ArrayList<>();

    public Curso(int id, String name, String anioEscolar, String aula) {
        this.id = id;
        this.name = name;
        this.anioEscolar = anioEscolar;
        this.aula = aula;
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void inscribirAlumno(Alumno alumno){
        Inscripcion inscripcion = new Inscripcion(alumno,this, LocalDate.now());
        inscripciones.add(inscripcion);
    }

    public void retirarAlumno(Alumno alumno){
        inscripciones.removeIf(inscrito -> inscrito.getAlumno().equals(alumno));
    }

    public List<Alumno> obtenerAlumnosInscritos(){
        return  inscripciones.stream()
                .map(Inscripcion::getAlumno)
                .collect(Collectors.toList());
    }

}
