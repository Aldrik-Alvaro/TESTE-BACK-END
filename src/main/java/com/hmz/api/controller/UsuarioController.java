package com.hmz.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmz.api.entity.Usuario;
import com.hmz.api.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    //Endpoint para lista de usuários
    @GetMapping
    public List<Usuario> todosUsuarios() {
        return usuarioService.todosUsuarios();
    }
    
    //Endpoint usuário por id
    @GetMapping(value = "/{id}")
    public Usuario buscarPeloId(@PathVariable("id") Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    //Endpoint para novo usurio
    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return usuarioService.novoUsuario(usuario);
    }
    
    //Endpoint atualizar usuário por id
    @PutMapping(value = "/{id}")
    public Usuario atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }

    //Endpoint deletar usuário por id
    @DeleteMapping(value = "/{id}")
    public void deletarUsuario(@PathVariable("id") Long id) {
        usuarioService.deletarUsuario(id);
    }

    //Endpoint para login
    @PostMapping(value = "/login")
    public Usuario login(@RequestBody Usuario usuario) {
        return usuarioService.login(usuario.getEmail(), usuario.getSenha());
    }
}
