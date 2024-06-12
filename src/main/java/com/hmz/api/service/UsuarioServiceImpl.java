package com.hmz.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmz.api.entity.Usuario;
import com.hmz.api.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired    
    private UsuarioRepository usuarioRepo;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario novoUsuario(Usuario usuario) {
        if(usuario.getNome() == null || usuario.getNome().isEmpty() ||
           usuario.getSenha() == null || usuario.getSenha().isEmpty() ||
           usuario.getUsername() == null || usuario.getUsername().isEmpty() ||
           usuario.getEmail() == null || usuario.getEmail().isEmpty() ||
           usuario.getRole() == null || usuario.getRole().isEmpty()) {
            throw new IllegalArgumentException("Parâmetros inválidos!");
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public List<Usuario> todosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepo.findById(id);
        if(optionalUsuario.isEmpty()) {
            throw new IllegalArgumentException("Id não existe!");
        }
        return optionalUsuario.get();
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario existingUsuario = buscarUsuarioPorId(id);
        if(usuario.getNome() != null && !usuario.getNome().isEmpty()) {
            existingUsuario.setNome(usuario.getNome());
        }
        if(usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
            existingUsuario.setSenha(usuario.getSenha());
        }
        if(usuario.getUsername() != null && !usuario.getUsername().isEmpty()) {
            existingUsuario.setUsername(usuario.getUsername());
        }
        if(usuario.getEmail() != null && !usuario.getEmail().isEmpty()) {
            existingUsuario.setEmail(usuario.getEmail());
        }
        if(usuario.getRole() != null && !usuario.getRole().isEmpty()) {
            existingUsuario.setRole(usuario.getRole());
        }
        
        return usuarioRepo.save(existingUsuario);
    }

    @Override
    public void deletarUsuario(Long id) {
        Usuario usuario = buscarUsuarioPorId(id);
        usuarioRepo.delete(usuario);
    }

    @Override
    public Usuario login(String username, String senha) {
        Usuario usuario = usuarioRepo.findByUsernameAndSenha(username, senha);
        if(usuario == null) {
            throw new IllegalArgumentException("Username ou senha incorretos!");
        }
        return usuario;
    }
}
