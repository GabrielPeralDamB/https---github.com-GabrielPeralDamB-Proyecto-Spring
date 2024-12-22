package com.example.tiendaonline.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tiendaonline.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombreContainsIgnoreCaseOrEmailContainsIgnoreCaseOrTelefonoContainsIgnoreCaseOrDniContainsIgnoreCase(String nombre,String email,String telefono,String dni);
}
