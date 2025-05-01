package com.lospapus.apiRestProyect.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Profesor {
    private Long id;
    private String nombre;
    private String email;
    private LocalDate fechaContratacion;

    public Profesor(String nombre, String email, LocalDate fechaContratacion) {
        this.nombre = nombre;
        this.email = email;
        this.fechaContratacion = fechaContratacion;
    }

    public void actualizarEmail(String nuevoEmail) {
        validarEmail(nuevoEmail);
        this.email = nuevoEmail;
    }

    private void validarEmail(String email) {
        if (email == null || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("El correo no tiene un formato válido");
        }
    }

}
