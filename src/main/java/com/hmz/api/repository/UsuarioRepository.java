package com.hmz.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmz.api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByNome(String nome);

	public Usuario findByUsernameAndSenha(String username, String senha);
    
}
