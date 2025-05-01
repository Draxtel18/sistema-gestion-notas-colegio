package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.domain.model.Alumno;
import com.lospapus.apiRestProyect.domain.repository.AlumnoRepository;
import com.lospapus.apiRestProyect.infraestructure.Mapper.AlumnoMapper;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.AlumnoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AlumnoRepositoryJPAImpl implements AlumnoRepository {
    private final AlumnoRepositoryJPA alumnoRepositoryJPA;
    private final AlumnoMapper mapper;

    @Autowired
    public AlumnoRepositoryJPAImpl(AlumnoRepositoryJPA alumnoRepositoryJPA, AlumnoMapper alumnoMapper){
        this.alumnoRepositoryJPA = alumnoRepositoryJPA;
        this.mapper = alumnoMapper;
    }

    @Override
    public Alumno save(Alumno alumno) {
        AlumnoEntity entity = mapper.toEntity(alumno);
        AlumnoEntity guardadaEntity = alumnoRepositoryJPA.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Alumno> findById(Long id) {
        return alumnoRepositoryJPA.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Alumno> findByEmail(String email) {
        return alumnoRepositoryJPA.findByEmail(email)
                .map(mapper::toDomain);
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoRepositoryJPA.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
