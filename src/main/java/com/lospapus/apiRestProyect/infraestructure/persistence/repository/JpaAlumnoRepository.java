package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.application.Mapper.AlumnoMapper;
import com.lospapus.apiRestProyect.domain.model.Alumno;
import com.lospapus.apiRestProyect.domain.repository.AlumnoRepository;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.AlumnoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaAlumnoRepository implements AlumnoRepository {
    private final AlumnoMapper mapper;
    private final SpringDataAlumnoRepository alumnoRepository;

    public JpaAlumnoRepository(SpringDataAlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper){
        this.alumnoRepository = alumnoRepository;
        this.mapper = alumnoMapper;
    }

    @Override
    public Alumno save(Alumno alumno) {
        AlumnoEntity entity = mapper.toEntity(alumno);
        AlumnoEntity guardadaEntity = alumnoRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Alumno> findById(int id) {
        return alumnoRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Alumno> findByEmail(String email) {
        return alumnoRepository.findByEmail(email)
                .map(mapper::toDomain);
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
