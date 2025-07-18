package com.perfulandia.AutenticacionService.AutenticacionService.service;

import com.perfulandia.AutenticacionService.AutenticacionService.model.Usuario;
import java.util.List;

import com.perfulandia.AutenticacionService.AutenticacionService.repository.AutenticacionRepository;
import org.springframework.stereotype.Service;

@Service

public class AutenticationService {
    private final AutenticacionRepository repo;

    public AutenticationService(AutenticacionRepository repo) {
        this.repo = repo;
    }

    ;

    public Usuario autenticar(String correo, String contrasena) {
        return repo.findByCorreo(correo).filter(u -> u.getContrasena().equals(contrasena)).orElse(null);
    }
}

