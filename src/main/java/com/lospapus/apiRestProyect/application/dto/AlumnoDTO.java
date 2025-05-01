package com.lospapus.apiRestProyect.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO {
    private Long id;
    private String name;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaNacimiento;
    private boolean active;
}
