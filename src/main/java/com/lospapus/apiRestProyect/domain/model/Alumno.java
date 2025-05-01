package com.lospapus.apiRestProyect.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    private Long id;
    private String name;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaNacimiento;
    private LocalDate fechaRegistro;
    private boolean active = true;
    private List<Inscripcion> inscripciones = new ArrayList<>();
    private List<Nota> notas = new ArrayList<>();

    public Alumno(String name, String direccion, String telefono, String email, Date fechaNacimiento) {
        this.name = name;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Alumno(Long id, String name, String direccion, String telefono, String email, Date fechaNacimiento, boolean active) {
        this.id = id;
        this.name = name;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.active = active;
    }

    public void agregarInscripcion(Curso curso){
        Inscripcion inscripcion = new Inscripcion(this,curso,LocalDate.now());
        inscripciones.add(inscripcion);
    }

    public void retirarCurso(Curso curso){
        inscripciones.removeIf(inscripcion -> inscripcion.getCurso().equals(curso));
    }

    public List<Curso> obtenerCursosInscritos(){
        return inscripciones.stream()
                .map(Inscripcion::getCurso)
                .collect(Collectors.toList());
    }

    public Optional<Nota> obtenerNotasPorCurso(Curso curso){
        return notas.stream()
                .filter(nota -> nota.getCurso().equals(curso))
                .findFirst();
    }

    public double calcularPromedioGeneral(){
        if(notas.isEmpty()){
            return 0.0;
        }

        double notaTotal = notas.stream()
                .mapToDouble(Nota::getNotaValor)
                .sum();

        return  notaTotal / notas.size();
    }

    public void actualizarInformacionContacto(String direccion, String telefono, String email) {
        if (email != null && !email.isEmpty()) {
            validarEmail(email);
            this.email = email;
        }
        if (telefono != null && !telefono.isEmpty()) {
            validarTelefono(telefono);
            this.telefono = telefono;
        }
        if (direccion != null) {
            this.direccion = direccion;
        }
    }

    public void desactivar() {
        this.active = false;
    }

    public void reactivar() {
        this.active = true;
    }

    private void validarEmail(String email) {
        if (email == null || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("El correo no tiene un formato válido");
        }
    }

    private void validarTelefono(String telefono) {
        if (telefono == null || !telefono.matches("^\\d{9}$")) {
            throw new IllegalArgumentException("El teléfono debe contener 9 digitos");
        }
    }
}
