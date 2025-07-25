package com.lospapus.apiRestProyect.application.Mapper;

import com.lospapus.apiRestProyect.application.dto.CrearCursoRequestDTO;
import com.lospapus.apiRestProyect.application.dto.CursoResponseDTO;
import com.lospapus.apiRestProyect.application.dto.InscripcionRequestDTO;
import com.lospapus.apiRestProyect.application.dto.InscripcionResponseDTO;
import com.lospapus.apiRestProyect.domain.model.Curso;
import com.lospapus.apiRestProyect.domain.model.Inscripcion;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.InscripcionEntity;

public class InscripcionMapper {
    public static Inscripcion toDomain(InscripcionEntity entity) {
        if (entity == null) return null;

        return new Inscripcion(
                entity.getId(),
                UsuarioMapper.toDomain(entity.getAlumno()),
                CursoMapper.toDomain(entity.getCursoEntity()),
                entity.getFechaInscripcion()
        );
    }

    public static InscripcionEntity toEntity(Inscripcion domain) {
        if (domain == null) return null;

        InscripcionEntity entity = new InscripcionEntity();
        entity.setId(domain.getId());
        entity.setAlumno(UsuarioMapper.toEntity(domain.getAlumno()));
        entity.setCursoEntity(CursoMapper.toEntity(domain.getCurso()));
        entity.setFechaInscripcion(domain.getFechaInscripcion());

        return entity;
    }

    // Mapea de Modelo de Dominio a DTO de Respuesta
    public static InscripcionResponseDTO toInscripcionResponseDTO(Inscripcion inscripcionDomain) {
        return new InscripcionResponseDTO(
                inscripcionDomain.getId(),
                inscripcionDomain.getAlumno(),
                inscripcionDomain.getCurso()
        );
    }

    // Mapea de DTO de Solicitud (Creación) a Modelo de Dominio
    public static Inscripcion toDomain(InscripcionRequestDTO requestDTO) {

        return new Inscripcion(
                null,
                requestDTO.getIdAlumno(),
                requestDTO.getIdCurso()
        );
    }
}
