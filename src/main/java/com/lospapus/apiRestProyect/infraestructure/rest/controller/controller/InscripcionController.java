package com.lospapus.apiRestProyect.infraestructure.rest.controller.controller;

import com.lospapus.apiRestProyect.application.dto.InscripcionRequestDTO;
import com.lospapus.apiRestProyect.application.dto.InscripcionResponseDTO;
import com.lospapus.apiRestProyect.application.service.InscripcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/inscripcion")
public class InscripcionController {
    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService){
        this.inscripcionService = inscripcionService;
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping
    public ResponseEntity<Void> inscribir(@RequestBody InscripcionRequestDTO dto) {
        inscripcionService.inscribir(dto);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'ALUMNO')")
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<InscripcionResponseDTO>> obtenerCursosUsuario(@PathVariable int usuarioId) {
        return ResponseEntity.ok(inscripcionService.obtenerCursosPorUsuario(usuarioId));
    }
}
