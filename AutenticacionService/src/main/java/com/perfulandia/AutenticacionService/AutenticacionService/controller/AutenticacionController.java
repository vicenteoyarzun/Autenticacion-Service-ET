package com.perfulandia.AutenticacionService.AutenticacionService.controller;
import com.perfulandia.AutenticacionService.AutenticacionService.model.Usuario;
import com.perfulandia.AutenticacionService.AutenticacionService.service.AutenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@Tag(name = "Autenticación", description = "API para manejar la autenticación de usuarios")
public class AutenticacionController {

    private final AutenticationService service;

    public AutenticacionController(AutenticationService service) {
        this.service = service;
    }

    @Operation(summary = "Autenticar usuario", description = "Valida las credenciales del usuario y devuelve sus datos si son correctos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Autenticación exitosa",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Usuario.class)) }),
        @ApiResponse(responseCode = "401", description = "Credenciales inválidas",
                    content = @Content) 
    })
    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody Usuario usuario) {
        Usuario iniciosesion = service.autenticar(usuario.getCorreo(), usuario.getContrasena());
        if (iniciosesion != null) {
            return ResponseEntity.ok(iniciosesion);
        } else {
            return ResponseEntity.status(401).body("Contraseña o usuario incorrecto");
        }
    }
}
