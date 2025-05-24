package com.lospapus.apiRestProyect.application.service;

import com.lospapus.apiRestProyect.domain.model.Curso;
import com.lospapus.apiRestProyect.domain.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> obtenerCursos(){
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarPorID(int id){
        return cursoRepository.buscarCursoPorId(id);
    }

    public Curso crearCurso(Curso curso){
        return cursoRepository.save(curso);
    }
}
