package com.lospapus.apiRestProyect.service;

import com.lospapus.apiRestProyect.model.Curso;
import com.lospapus.apiRestProyect.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> findById(int id) {
        return cursoRepository.findById(id);
    }

    public void deleteById(int id) {
        cursoRepository.deleteById(id);
    }
}
