package com.example.tiendaonline.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tiendaonline.entidades.Usuario;
import com.example.tiendaonline.servicios.UsuarioServicio;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioServicio.search(email).get(0);

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword()) // Asegúrate de que la contraseña está cifrada
                .roles(usuario.getTipoUsuario().toUpperCase()) // "admin", "usuario", "empleado"
                .build();
    }
}

