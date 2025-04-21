package com.lospapus.apiRestProyect.service;

import com.lospapus.apiRestProyect.model.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {
    private final List<Curso> cursoList = new ArrayList<>();

    public List<Curso> findAll(){
        return cursoList;
    }

    public Curso save(Curso curso) {
        cursoList.add(curso);
        return curso;
    }
}
