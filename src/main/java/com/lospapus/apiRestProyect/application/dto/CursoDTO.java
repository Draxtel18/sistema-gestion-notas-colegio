package com.lospapus.apiRestProyect.application.dto;

import com.lospapus.apiRestProyect.domain.model.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    private Long id;
    private String name;
    private String anioEscolar;
    private String aula;
    private Profesor profesor;
}

