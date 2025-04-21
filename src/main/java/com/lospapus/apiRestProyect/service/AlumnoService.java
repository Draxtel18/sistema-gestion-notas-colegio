package com.lospapus.apiRestProyect.service;

import com.lospapus.apiRestProyect.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService {
    private final List<Alumno> alumnoList = new ArrayList<>();

    public List<Alumno> findAll(){
        return alumnoList;
    }

    public Alumno save(Alumno alumno) {
        alumnoList.add(alumno);
        return alumno;
    }
}
