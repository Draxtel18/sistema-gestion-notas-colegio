package com.lospapus.apiRestProyect.application.service;

import com.lospapus.apiRestProyect.application.Mapper.AplicacionMapper;
import com.lospapus.apiRestProyect.application.dto.NotaResponseDTO;
import com.lospapus.apiRestProyect.application.dto.RegistrarNotaRequestDTO;
import com.lospapus.apiRestProyect.application.dto.UsuarioResponseDTO;
import com.lospapus.apiRestProyect.domain.model.Asignaciones;
import com.lospapus.apiRestProyect.domain.model.Nota;
import com.lospapus.apiRestProyect.domain.model.Usuario;
import com.lospapus.apiRestProyect.domain.repository.AsignacionesRepository;
import com.lospapus.apiRestProyect.domain.repository.NotaRepository;
import com.lospapus.apiRestProyect.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaService {
    private final NotaRepository notaRepository;
    private final UsuarioRepository usuarioRepository;
    private final AsignacionesRepository asignacionesRepository;
    private final AplicacionMapper aplicacionMapper;

    public NotaService(NotaRepository notaRepository,
                       UsuarioRepository usuarioRepository,
                       AsignacionesRepository asignacionesRepository,
                       AplicacionMapper aplicacionMapper) {
        this.notaRepository = notaRepository;
        this.usuarioRepository = usuarioRepository;
        this.asignacionesRepository = asignacionesRepository;
        this.aplicacionMapper = aplicacionMapper;
    }

    @Transactional
    public NotaResponseDTO registrarNota(RegistrarNotaRequestDTO requestDTO) {
        Usuario alumno = usuarioRepository.findById(requestDTO.getIdAlumno())
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + requestDTO.getIdAlumno()));
        if (!alumno.esAlumno()) {
            throw new IllegalArgumentException("El usuario con ID " + requestDTO.getIdAlumno() + " no es un alumno.");
        }

        Asignaciones asignaciones = asignacionesRepository
                .buscarPorId(requestDTO.getIdAsignacion())
                .orElseThrow(() -> new RuntimeException("Asignación Profesor-Asignatura-Curso no encontrada con ID: " + requestDTO.getIdAsignacion()));

        // --- Paso 2: Aplicar las restricciones de negocio ---
        // Aquí es donde un PROFESOR solo puede ver/asignar notas a SUS alumnos por curso.
        // Asume que el ID del profesor logueado se obtiene del contexto de seguridad (Spring Security).
        // Long idProfesorLogueado = SecurityContextHolder.getContext().getAuthentication().getPrincipal().getId(); // Ejemplo

        // if (!asignaciones.getProfesor().getId().equals(idProfesorLogueado)) {
        //     throw new SecurityException("El profesor no tiene permiso para asignar notas en esta asignación.");
        // }
        // if (!asignaciones.getCurso().equals(alumno.getCursoAlQuePertenece())) { // Requiere que el alumno tenga un curso principal
        //    // Lógica para verificar que el alumno pertenece al curso de la asignación
        //    // Esto podría implicar buscar en AlumnoCursoRepository
        // }


        Nota nuevaNotaDomain = new Nota(
                alumno,
                asignaciones,
                requestDTO.getCalificacion(),
                requestDTO.getComentario(),
                LocalDate.now()
        );

        Nota notaPersistidaDomain = notaRepository.guardar(nuevaNotaDomain);

        return aplicacionMapper.toNotaResponseDTO(notaPersistidaDomain);
    }

    public List<NotaResponseDTO> obtenerNotasDeAlumno(int idAlumno) {
        // Restricción: Un alumno solo puede ver sus propias notas.
        // Long idAlumnoLogueado = SecurityContextHolder.getContext().getAuthentication().getPrincipal().getId();
        // if (!idAlumno.equals(idAlumnoLogueado)) {
        //     throw new SecurityException("El alumno solo puede ver sus propias notas.");
        // }

        List<Nota> notasDomain = notaRepository.buscarPorAlumnoId(idAlumno);

        return notasDomain.stream()
                .map(aplicacionMapper::toNotaResponseDTO)
                .collect(Collectors.toList());
    }

    public List<NotaResponseDTO> listarTodoasNotas(){
        List<Nota> notaDomain = notaRepository.buscarTodos();

        return notaDomain.stream()
                .map(aplicacionMapper::toNotaResponseDTO)
                .collect(Collectors.toList());
    }
}
