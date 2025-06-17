package com.example.demo.model;

import jakarta.persistence.*;

/**
 * Representa um usuário do sistema com email e senha.
 * A senha deve ser armazenada de forma segura, preferencialmente com hash.
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    /** Identificador único do usuário */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Email do usuário, usado para autenticação */
    private String email;

    /** Senha do usuário armazenada em formato hash */
    private String senha; // armazenada com hash

    /**
     * Retorna o identificador único do usuário.
     * @return id do usuário
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do usuário.
     * @param id identificador do usuário
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o email do usuário.
     * @return email do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     * @param email email do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna a senha do usuário.
     * @return senha em hash
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     * @param senha senha em hash
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
