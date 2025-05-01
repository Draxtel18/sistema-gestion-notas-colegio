package com.lospapus.apiRestProyect.infraestructure.Mapper;

import com.lospapus.apiRestProyect.application.dto.AlumnoDTO;
import com.lospapus.apiRestProyect.application.dto.CursoDTO;
import com.lospapus.apiRestProyect.domain.model.Alumno;
import com.lospapus.apiRestProyect.domain.model.Curso;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.AlumnoEntity;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.CursoEntity;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public CursoEntity toEntity(Curso curso) {
        CursoEntity entity = new CursoEntity();
        entity.setId(curso.getId());
        entity.setName(curso.getName());
        entity.setAula(curso.getAula());
        entity.setAnioEscolar(curso.getAnioEscolar());
        return entity;
    }

    public Curso toDomain(CursoEntity entity) {
        return new Curso(
                entity.getId(),
                entity.getName(),
                entity.getAnioEscolar(),
                entity.getAula()
        );
    }
}
