package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.domain.model.Curso;
import com.lospapus.apiRestProyect.domain.repository.CursoRepository;
import com.lospapus.apiRestProyect.application.Mapper.CursoMapper;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.CursoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaCursoRepository implements CursoRepository {
    private final CursoMapper cursoMapper;
    private final SpringDataCursoRepository cursoRepositoryJPA;


    public JpaCursoRepository(SpringDataCursoRepository cursoRepositoryJPA, CursoMapper cursoMapper){
        this.cursoRepositoryJPA = cursoRepositoryJPA;
        this.cursoMapper = cursoMapper;
    }

    @Override
    public Curso save(Curso curso) {
        CursoEntity cursoEntity = cursoMapper.toEntity(curso);
        return cursoMapper.toDomain(cursoRepositoryJPA.save(cursoEntity));
    }

    @Override
    public Optional<Curso> buscarCursoPorId(int id) {
        return cursoRepositoryJPA.findById(id)
                .map(cursoMapper::toDomain);
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepositoryJPA.findAll().stream()
                .map(cursoMapper::toDomain)
                .collect(Collectors.toList());
    }
}
