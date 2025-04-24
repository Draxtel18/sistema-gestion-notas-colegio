package com.lospapus.apiRestProyect.controller;

import com.lospapus.apiRestProyect.model.Nota;
import com.lospapus.apiRestProyect.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public List<Nota> listar() {
        return notaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Nota> obtenerPorId(@PathVariable Long id) {
        return notaService.obtenerPorId(id);
    }

    @PostMapping
    public Nota registrar(@RequestBody Nota nota) {
        return notaService.guardar(nota);
    }

    @PutMapping("/{id}")
    public Nota actualizar(@PathVariable Long id, @RequestBody Nota nota) {
        nota.setId(id);
        return notaService.guardar(nota);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        notaService.eliminar(id);
    }
}
