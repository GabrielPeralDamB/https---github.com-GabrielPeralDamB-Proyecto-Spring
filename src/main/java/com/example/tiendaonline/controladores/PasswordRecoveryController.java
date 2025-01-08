package com.example.tiendaonline.controladores;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiendaonline.entidades.Usuario;
import com.example.tiendaonline.servicios.UsuarioServicio;

@RestController
@RequestMapping("/auth")
public class PasswordRecoveryController {

    private final UsuarioServicio usuarioServicio;

    public PasswordRecoveryController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping("/recuperar-password")
    public ResponseEntity<String> recuperarPassword(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");

        Usuario usuario = usuarioServicio.search(email).get(0);
        if (usuario == null) {
            return ResponseEntity.badRequest().body("No se encontró un usuario con ese correo electrónico.");
        }

        // Generar una contraseña temporal o enlace de recuperación
        String nuevaPassword = "temporal123"; // Mejora esto con generación segura
        usuario.setPassword(nuevaPassword);
        usuarioServicio.add(usuario);

        // Simula el envío de correo (puedes integrar con JavaMail)
        System.out.println("Correo enviado a " + email + " con la nueva contraseña: " + nuevaPassword);

        return ResponseEntity.ok("Se envió un correo electrónico con las instrucciones.");
    }

    @GetMapping("/recuperar-password")
    public String mostrarFormularioRecuperacion() {
        return "recuperar_password"; // Nombre de tu plantilla HTML para recuperar contraseña
    }
}

