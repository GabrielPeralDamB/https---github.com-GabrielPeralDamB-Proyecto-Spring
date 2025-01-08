package com.example.tiendaonline.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiendaonline.entidades.Usuario;
import com.example.tiendaonline.servicios.UsuarioServicio;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioServicio usuarioServicio;

    public AuthController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping("/registro")
public String registrarUsuario(@ModelAttribute Usuario usuario, Model model) {
    try {
        usuarioServicio.add(usuario);
        model.addAttribute("mensaje", "Usuario registrado con éxito");
        return "redirect:/login?registroExitoso";
    } catch (Exception e) {
        model.addAttribute("error", "Error al registrar usuario: " + e.getMessage());
        return "registro"; // Redirige de vuelta al formulario de registro con el mensaje de error
    }
}

    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "registro"; // Nombre de tu plantilla HTML para registro
    }

}
