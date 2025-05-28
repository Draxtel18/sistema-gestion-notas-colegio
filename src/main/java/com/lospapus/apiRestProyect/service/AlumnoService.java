package com.lospapus.apiRestProyect.service;

import com.lospapus.apiRestProyect.model.Alumno;
import com.lospapus.apiRestProyect.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> findById(int id) {
        return alumnoRepository.findById(id);
    }

    public void deleteById(int id) {
        alumnoRepository.deleteById(id);
    }
}
