package com.hmz.api.service;

import java.util.List;

import com.hmz.api.entity.Usuario;

public interface UsuarioService {
    
    public Usuario novoUsuario(Usuario usuario);

    public List<Usuario> todosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public Usuario atualizarUsuario(Long id, Usuario usuario);

    public void deletarUsuario(Long id);

    public Usuario login(String username, String senha);
}
