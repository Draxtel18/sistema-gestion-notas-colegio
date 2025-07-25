package com.lospapus.apiRestProyect.infraestructure.persistence.repository;

import com.lospapus.apiRestProyect.application.Mapper.InscripcionMapper;
import com.lospapus.apiRestProyect.domain.model.Inscripcion;
import com.lospapus.apiRestProyect.domain.repository.InscripcionRepository;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.CursoEntity;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.InscripcionEntity;
import com.lospapus.apiRestProyect.infraestructure.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaInscripcionRepository implements InscripcionRepository {
    private final SpringDataInscripcionRepository inscripcionRepository;
    private final SpringDataCursoRepository cursoRepository;
    private final SpringDataUsuarioRepository usuarioRepository;

    public JpaInscripcionRepository(SpringDataInscripcionRepository inscripcionRepository, SpringDataCursoRepository cursoRepository, SpringDataUsuarioRepository usuarioRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Inscripcion save(Inscripcion inscripcion) {
        InscripcionEntity entity = inscripcion.getId() != null
                ? inscripcionRepository.findById(inscripcion.getId())
                .orElse(new InscripcionEntity())
                : new InscripcionEntity();


        UsuarioEntity usuarioEntity = usuarioRepository.findById(inscripcion.getAlumno().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        entity.setAlumno(usuarioEntity);


        CursoEntity cursoEntity = cursoRepository.findById(inscripcion.getCurso().getId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        entity.setCursoEntity(cursoEntity);


        entity.setFechaInscripcion(LocalDate.now());

        return InscripcionMapper.toDomain(inscripcionRepository.save(entity));
    }

    @Override
    public List<Inscripcion> findByUsuarioId(int usuarioId) {
        return inscripcionRepository.findByAlumnoId(usuarioId).stream()
                .map(InscripcionMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Inscripcion> findByUsuarioAndCurso(int usuarioId, int cursoId) {
        return inscripcionRepository.findByAlumnoIdAndCursoEntityId(usuarioId, cursoId)
                .map(InscripcionMapper::toDomain);
    }
}
