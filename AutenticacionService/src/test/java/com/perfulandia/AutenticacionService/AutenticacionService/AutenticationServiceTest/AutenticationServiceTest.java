package com.perfulandia.AutenticacionService.AutenticacionService.AutenticationServiceTest;
import com.perfulandia.AutenticacionService.AutenticacionService.service.AutenticationService;
import com.perfulandia.AutenticacionService.AutenticacionService.model.Usuario;
import com.perfulandia.AutenticacionService.AutenticacionService.repository.AutenticacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AutenticationServiceTest {

    @Mock
    private AutenticacionRepository repository;

    @InjectMocks
    private AutenticationService service;

    private Usuario usuarioValido;

    @BeforeEach
    void setUp() {
        usuarioValido = new Usuario();
        usuarioValido.setId(1L);
        usuarioValido.setCorreo("ejemplo@gmail.com");
        usuarioValido.setContrasena("321123");
    }

    @Test
    void testAutenticarExitoso() {
        when(repository.findByCorreo("ejemplo@gmail.com")).thenReturn(Optional.of(usuarioValido));

        Usuario resultado = service.autenticar("ejemplo@gmail.com", "321123");

        assertNotNull(resultado);
        assertEquals("ejemplo@gmail.com", resultado.getCorreo());
        verify(repository).findByCorreo("ejemplo@gmail.com");
    }

    @Test
    void testAutenticarContrasenaIncorrecta() {
        when(repository.findByCorreo("ejemplo@gmail.com")).thenReturn(Optional.of(usuarioValido));

        Usuario resultado = service.autenticar("ejemplo@gmail.com", "123321");

        assertNull(resultado);
        verify(repository).findByCorreo("ejemplo@gmail.com");
    }

    @Test
    void testAutenticarUsuarioNoExiste() {
        when(repository.findByCorreo("noexiste@gmail.com")).thenReturn(Optional.empty());

        Usuario resultado = service.autenticar("noexiste@gmail.com", "nose");

        assertNull(resultado);
        verify(repository).findByCorreo("noexiste@gmail.com");
    }
}