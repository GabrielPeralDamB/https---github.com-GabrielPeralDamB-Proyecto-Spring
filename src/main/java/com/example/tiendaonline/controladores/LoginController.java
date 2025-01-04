package com.example.tiendaonline.controladores;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/default")
    public String defaultAfterLogin(Authentication authentication, HttpSession session) {
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        session.setAttribute("userRole", role);
        if ("ROLE_ADMIN".equals(role)) {
            return "redirect:/admin";
        } else if ("ROLE_EMPLEADO".equals(role)) {
            return "redirect:/empleado";
        } else {
            return "redirect:/index";
        }
    }
}


