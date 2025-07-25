package com.lospapus.apiRestProyect.application.service;

import com.lospapus.apiRestProyect.application.Mapper.AplicacionMapper;
import com.lospapus.apiRestProyect.application.dto.InscripcionRequestDTO;
import com.lospapus.apiRestProyect.application.dto.InscripcionResponseDTO;
import com.lospapus.apiRestProyect.domain.model.Curso;
import com.lospapus.apiRestProyect.domain.model.Inscripcion;
import com.lospapus.apiRestProyect.domain.model.Nota;
import com.lospapus.apiRestProyect.domain.model.Usuario;
import com.lospapus.apiRestProyect.domain.repository.CursoRepository;
import com.lospapus.apiRestProyect.domain.repository.InscripcionRepository;
import com.lospapus.apiRestProyect.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionService {
    private final InscripcionRepository inscripcionRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;
    private final AplicacionMapper aplicacionMapper;

    public InscripcionService(InscripcionRepository inscripcionRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository, AplicacionMapper aplicacionMapper) {
        this.inscripcionRepository = inscripcionRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
        this.aplicacionMapper = aplicacionMapper;
    }

    @Transactional
    public void inscribir(InscripcionRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdAlumno())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Validar duplicado
        if (inscripcionRepository.findByUsuarioAndCurso(dto.getIdAlumno(), dto.getIdCurso()).isPresent()) {
            throw new RuntimeException("Alumno ya inscrito en este curso");
        }

        Inscripcion inscripcion = new Inscripcion(null, usuario, curso, null);
        inscripcionRepository.save(inscripcion);
    }

    public List<InscripcionResponseDTO> obtenerCursosPorUsuario(int usuarioId) {
        List<Inscripcion> inscripcionDomain = inscripcionRepository.findByUsuarioId(usuarioId);

        return inscripcionDomain.stream()
                .map(aplicacionMapper::toInscripcionResponseDTO)
                .collect(Collectors.toList());

    }
}
