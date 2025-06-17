package com.example.demo.dao;

import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface para operações de persistência da entidade {@link Usuario}.
 * Extende {@link JpaRepository} para fornecer métodos padrão de CRUD.
 *
 * Inclui método para buscar usuário pelo email.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    /**
     * Busca um usuário pelo seu email.
     *
     * @param email o email do usuário a ser buscado.
     * @return um Optional contendo o usuário se encontrado, ou vazio caso contrário.
     */
    Optional<Usuario> findByEmail(String email);
}
