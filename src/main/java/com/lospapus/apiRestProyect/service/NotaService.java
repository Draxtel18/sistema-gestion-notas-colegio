package com.lospapus.apiRestProyect.service;

import com.lospapus.apiRestProyect.model.Nota;
import com.lospapus.apiRestProyect.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public List<Nota> obtenerTodas() {
        return notaRepository.findAll();
    }

    public Optional<Nota> obtenerPorId(Long id) {
        return notaRepository.findById(id);
    }

    public Nota guardar(Nota nota) {
        return notaRepository.save(nota);
    }

    public void eliminar(Long id) {
        notaRepository.deleteById(id);
    }
}
