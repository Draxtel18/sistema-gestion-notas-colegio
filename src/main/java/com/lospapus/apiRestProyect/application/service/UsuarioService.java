package com.lospapus.apiRestProyect.application.service;

import com.lospapus.apiRestProyect.application.Mapper.AplicacionMapper;
import com.lospapus.apiRestProyect.application.Mapper.UsuarioMapper;
import com.lospapus.apiRestProyect.application.dto.CrearUsuarioRequestDTO;
import com.lospapus.apiRestProyect.application.dto.UsuarioResponseDTO;
import com.lospapus.apiRestProyect.domain.model.Nota;
import com.lospapus.apiRestProyect.domain.model.Rol;
import com.lospapus.apiRestProyect.domain.model.Usuario;
import com.lospapus.apiRestProyect.domain.repository.RolRepository;
import com.lospapus.apiRestProyect.domain.repository.UsuarioRepository;
import com.sun.tools.jconsole.JConsoleContext;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final AplicacionMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository,AplicacionMapper mapper, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuarioResponseDTO> listarTodosUsuarios(){
        List<Usuario> usuariosDomain = usuarioRepository.findAll();

        return usuariosDomain.stream()
                .map(mapper::toUsuarioResponseDTO)
                .collect(Collectors.toList());
    }


    public UsuarioResponseDTO registrarUsuario( CrearUsuarioRequestDTO requestDTO) {
        Rol rol = rolRepository.findByRol(requestDTO.getNombreRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + requestDTO.getNombreRol()));

        if (usuarioRepository.findByEmail(requestDTO.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está en uso: " + requestDTO.getEmail());
        }

        Usuario usuarioDomain = new Usuario(
                requestDTO.getName(),
                requestDTO.getDni(),
                requestDTO.getDireccion(),
                requestDTO.getTelefono(),
                requestDTO.getEmail(),
                passwordEncoder.encode(requestDTO.getPassword()),
                requestDTO.getFechaNacimiento(),
                LocalDate.now(),
                true,
                rol
        );

        System.out.println(usuarioDomain);

        Usuario usuarioGuardado = usuarioRepository.save(usuarioDomain);

        return mapper.toUsuarioResponseDTO(usuarioGuardado);
    }
}
