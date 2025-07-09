package com.example.CrudRapido.dao;

import com.example.CrudRapido.entity.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    //boolean verificarCredenciales(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
