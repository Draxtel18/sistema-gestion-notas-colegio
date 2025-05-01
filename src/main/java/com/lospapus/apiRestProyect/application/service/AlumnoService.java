package com.lospapus.apiRestProyect.application.service;

import com.lospapus.apiRestProyect.application.Exception.AlumnoNoEncontradoException;
import com.lospapus.apiRestProyect.application.Exception.EmailDuplicadoException;
import com.lospapus.apiRestProyect.domain.model.Alumno;
import com.lospapus.apiRestProyect.domain.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService{
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }
    /*
    public Alumno registrarAlumno(String name, String direccion, String telefono, String email, Date fechaNacimiento){
        alumnoRepository.findByName(name).ifPresent(a -> {
            throw new EmailDuplicadoException("El email ya está registrado");
        });
        Alumno nuevoAlumno = new Alumno(name, direccion, telefono, email, fechaNacimiento);
        alumnoRepository.save(nuevoAlumno);
        return nuevoAlumno;
    }
    */
    public Alumno registrarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public Alumno actualizarAlumno(Long id, String direccion, String telefono, String email) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(()-> new AlumnoNoEncontradoException("Alumno no encontrado con ID: " + id));
        if (alumno == null) {
            throw new AlumnoNoEncontradoException("Alumno no encontrado con ID: " + id);
        }

        // Si el email cambia, verificamos que no exista
        if (email != null && !email.equals(alumno.getEmail())) {
            alumnoRepository.findByEmail(email).ifPresent(a -> {
                throw new EmailDuplicadoException("El email ya está registrado");
            });
        }

        alumno.actualizarInformacionContacto(direccion, telefono, email);
        alumnoRepository.save(alumno);
        return alumno;
    }

    public void desactivarAlumno(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(()-> new AlumnoNoEncontradoException("Alumno no encontrado con ID: " + id));
        alumno.desactivar();
        alumnoRepository.save(alumno);
    }

    public List<Alumno> listarTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno obtenerPorId(Long id){
        return alumnoRepository.findById(id)
                .orElseThrow(()-> new AlumnoNoEncontradoException("Alumno no encontrado con ID: " + id));
    }

}
