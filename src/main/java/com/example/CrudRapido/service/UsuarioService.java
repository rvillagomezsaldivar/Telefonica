package com.example.CrudRapido.service;

import com.example.CrudRapido.entity.Usuario;
import com.example.CrudRapido.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUsuario(Long id){
        return usuarioRepository.findById(id);
    }
}
