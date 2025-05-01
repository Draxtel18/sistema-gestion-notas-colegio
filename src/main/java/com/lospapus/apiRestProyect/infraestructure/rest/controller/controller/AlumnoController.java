package com.lospapus.apiRestProyect.infraestructure.rest.controller.controller;

import com.lospapus.apiRestProyect.application.dto.AlumnoDTO;
import com.lospapus.apiRestProyect.application.service.AlumnoService;
import com.lospapus.apiRestProyect.infraestructure.Mapper.AlumnoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/alumnos")
public class AlumnoController {
    private final AlumnoService alumnoService;
    private final AlumnoMapper alumnoMapper;

    public AlumnoController(AlumnoService alumnoService, AlumnoMapper alumnoMapper){
        this.alumnoService = alumnoService;
        this.alumnoMapper = alumnoMapper;
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> obtenerTodosLosALumnos(){
        return ResponseEntity.of(
                Optional.of(alumnoService.listarTodosLosAlumnos().stream()
                        .map(alumnoMapper::toDTO)
                        .collect(Collectors.toList()))
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<AlumnoDTO> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(
                alumnoMapper.toDTO(
                        alumnoService.obtenerPorId(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<AlumnoDTO> crearAlumno(@RequestBody AlumnoDTO alumnoDTO){
        return new ResponseEntity<>(
                alumnoMapper.toDTO(
                        alumnoService.registrarAlumno(alumnoMapper.toDomain(alumnoDTO))
                ),
                HttpStatus.CREATED
        );
    }
}
