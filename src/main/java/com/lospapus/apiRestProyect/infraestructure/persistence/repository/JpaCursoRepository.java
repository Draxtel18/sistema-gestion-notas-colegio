package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.application.Mapper.AsignaturaMapper;
import com.lospapus.apiRestProyect.application.Mapper.CursoMapper;
import com.lospapus.apiRestProyect.domain.model.Asignatura;
import com.lospapus.apiRestProyect.domain.model.Curso;
import com.lospapus.apiRestProyect.domain.repository.CursoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaCursoRepository implements CursoRepository {
    private final SpringDataCursoRepository cursoRepository;

    public JpaCursoRepository(SpringDataCursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll().stream()
                .map(CursoMapper::toDomain)
                .collect(Collectors.toList());
    }
}
