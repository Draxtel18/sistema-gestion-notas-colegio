package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.application.Mapper.AsignaturaMapper;
import com.lospapus.apiRestProyect.domain.model.Asignatura;
import com.lospapus.apiRestProyect.domain.repository.AsignaturaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaAsignaturaRepository implements AsignaturaRepository {
    private final SpringDataAsignaturaRepository asignaturaRepository;

    public JpaAsignaturaRepository(SpringDataAsignaturaRepository asignaturaRepository){
        this.asignaturaRepository = asignaturaRepository;
    }

    @Override
    public List<Asignatura> findAll() {
        return asignaturaRepository.findAll().stream()
                .map(AsignaturaMapper::toDomain)
                .collect(Collectors.toList());
    }
}
