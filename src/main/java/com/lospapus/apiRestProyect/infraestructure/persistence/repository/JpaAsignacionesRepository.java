package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.application.Mapper.AsignacionesMapper;
import com.lospapus.apiRestProyect.application.Mapper.AsignaturaMapper;
import com.lospapus.apiRestProyect.application.Mapper.CursoMapper;
import com.lospapus.apiRestProyect.application.Mapper.UsuarioMapper;
import com.lospapus.apiRestProyect.domain.model.Asignaciones;
import com.lospapus.apiRestProyect.domain.repository.AsignacionesRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaAsignacionesRepository implements AsignacionesRepository {
    private final SpringDataAsignacionRepository asignacionRepository;

    public JpaAsignacionesRepository(SpringDataAsignacionRepository asignacionRepository) {
        this.asignacionRepository = asignacionRepository;
    }

    @Override
    public Optional<Asignaciones> buscarPorId(int id) {
        return asignacionRepository.findById(id)
                .map(entity -> new Asignaciones(entity.getId(), CursoMapper.toDomain(entity.getCursoEntity()), AsignaturaMapper.toDomain(entity.getAsignaturaEntity()),UsuarioMapper.toDomain(entity.getProfesor())));
    }
}
