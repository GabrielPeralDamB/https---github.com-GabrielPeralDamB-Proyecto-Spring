package com.example.tiendaonline.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.tiendaonline.entidades.Usuario;
import com.example.tiendaonline.repositorios.UsuarioRepositorio;

@Primary
@Service("usuarioServicio")
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio repositorio;

    public Usuario add(Usuario e){
        return repositorio.save(e);
    }

    public List<Usuario> findAll(){
        return repositorio.findAll();
    }

    public Usuario findById(long id){
        return repositorio.findById(id).orElse(null);
    }

    public Usuario edit(Usuario e){
        return repositorio.save(e);
    }

    public List<Usuario> search(String consulta){
        return repositorio.findByNombreContainsIgnoreCaseOrEmailContainsIgnoreCaseOrTelefonoContainsIgnoreCaseOrDniContainsIgnoreCase(consulta, consulta, consulta, consulta);
    }
}
