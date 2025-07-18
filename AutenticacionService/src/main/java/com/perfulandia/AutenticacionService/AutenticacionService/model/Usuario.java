package com.perfulandia.AutenticacionService.AutenticacionService.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Modelo que representa un usuario en el sistema")
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Schema(description = "ID único del usuario", example = "1")
    private long id;
    
    @Schema(description = "Nombre completo del usuario", example = "Juan Pérez")
    private String nombre;
    
    @Schema(description = "Correo electrónico del usuario", example = "ejemplo@gmail.com")
    private String correo;
    
    @Schema(description = "Contraseña del usuario", example = "321123")
    private String contrasena;
    
    @Schema(description = "Rol del usuario en el sistema", example = "ADMIN")
    private String rol;
}
