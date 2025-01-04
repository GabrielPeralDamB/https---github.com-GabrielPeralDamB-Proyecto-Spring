package com.example.tiendaonline.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Controller
    @RequestMapping("/admin")
    public class AdminController {
        @GetMapping
        public String adminPage() {
            return "listausuario";
        }
    }

    @Controller
    @RequestMapping("/empleado")
    public class EmpleadoController {
        @GetMapping
        public String empleadoPage() {
            return "empleado";
        }
    }

    @Controller
    @RequestMapping("/index")
    public class UsuarioController {
        @GetMapping
        public String usuarioPage() {
            return "index";
        }
    }

}
