package com.perfulandia.AutenticacionService.AutenticacionService.repository;
import com.perfulandia.AutenticacionService.AutenticacionService.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface AutenticacionRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}
