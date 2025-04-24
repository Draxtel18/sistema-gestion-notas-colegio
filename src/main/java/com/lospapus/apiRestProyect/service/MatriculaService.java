package com.lospapus.apiRestProyect.service;

import com.lospapus.apiRestProyect.model.Matricula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaService {

    private final List<Matricula> matriculas = new ArrayList<>();

    public List<Matricula> obtenerTodas() {
        return matriculas;
    }

    public void registrarMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }

    public Matricula buscarPorId(Long id) {
        return matriculas.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminarMatricula(Long id) {
        return matriculas.removeIf(m -> m.getId().equals(id));
    }
}
