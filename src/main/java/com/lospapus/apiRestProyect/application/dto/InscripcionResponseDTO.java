package com.lospapus.apiRestProyect.application.dto;

import com.lospapus.apiRestProyect.domain.model.Curso;
import com.lospapus.apiRestProyect.domain.model.Usuario;
import lombok.Getter;

@Getter
public class InscripcionResponseDTO {
    private Integer id;
    private Usuario alumno;
    private Curso curso;

    public InscripcionResponseDTO(Integer id, Usuario alumno, Curso curso) {
        this.id = id;
        this.alumno = alumno;
        this.curso = curso;
    }

}
