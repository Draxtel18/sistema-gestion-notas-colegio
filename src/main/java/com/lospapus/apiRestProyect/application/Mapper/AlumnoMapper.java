package com.lospapus.apiRestProyect.application.Mapper;

import com.lospapus.apiRestProyect.application.dto.AlumnoDTO;
import com.lospapus.apiRestProyect.domain.model.Alumno;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.AlumnoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class AlumnoMapper {
    public AlumnoDTO toDTO(Alumno alumno) {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setId(alumno.getId());
        dto.setName(alumno.getName());
        dto.setDireccion(alumno.getDireccion());
        dto.setTelefono(alumno.getTelefono());
        dto.setEmail(alumno.getEmail());
        dto.setActive(alumno.isActive());
        return dto;
    }

    public Alumno toDomain(AlumnoDTO dto) {
        return new Alumno(
                dto.getId(),
                dto.getName(),
                dto.getDireccion(),
                dto.getTelefono(),
                dto.getEmail(),
                dto.getFechaNacimiento(),
                dto.isActive()
        );
    }

    public AlumnoEntity toEntity(Alumno alumno) {
        AlumnoEntity entity = new AlumnoEntity();
        entity.setId(alumno.getId());
        entity.setName(alumno.getName());
        entity.setDireccion(alumno.getDireccion());
        entity.setTelefono(alumno.getTelefono());
        entity.setEmail(alumno.getEmail());
        entity.setActive(alumno.isActive());
        entity.setFechaNacimiento(alumno.getFechaNacimiento());
        entity.setFechaRegistro(LocalDate.from(LocalDateTime.now()));
        return entity;
    }

    public Alumno toDomain(AlumnoEntity entity) {
        return new Alumno(
                entity.getId(),
                entity.getName(),
                entity.getDireccion(),
                entity.getTelefono(),
                entity.getEmail(),
                entity.getFechaNacimiento(),
                entity.isActive()
        );
    }
}
