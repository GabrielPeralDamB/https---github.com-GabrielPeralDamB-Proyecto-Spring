package com.example.tiendaonline.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.tiendaonline.servicios.UsuarioServicio;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/usuarios")
    public String listUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioServicio.findAll());
        return "listausuario";
    }
}
