package com.lospapus.apiRestProyect.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Curso {

    private int id;
    private String nombre;
    private String anoEscolar;
    private String aula;

    public Curso(int id, String nombre, String anoEscolar, String aula) {
        this.id = id;
        this.nombre = nombre;
        this.anoEscolar = anoEscolar;
        this.aula = aula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
}
