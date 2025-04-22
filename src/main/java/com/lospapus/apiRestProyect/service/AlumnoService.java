package com.lospapus.apiRestProyect.service;

import com.lospapus.apiRestProyect.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlumnoService {
    Date fechaNacimiento = new Date();
    Date fechaRegistro = new Date();
    public List<Alumno> alumnoList = new ArrayList<>(
            List.of(
                    new Alumno(
                    1,
                    "Asdy",
                    "Valdivia",
                    fechaNacimiento,
                    "Av. Ignacio Merino",
                    "9494970174",
                    "asdy@hshd.com",
                    fechaRegistro,
                    true
                    )
            )
    );

    public List<Alumno> findAll(){
        return alumnoList;
    }

    public Alumno save(Alumno alumno) {
        alumnoList.add(alumno);
        return alumno;
    }
}
