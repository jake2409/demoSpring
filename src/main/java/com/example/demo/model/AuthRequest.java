package com.example.demo.model;

/**
 * Representa uma requisição de autenticação contendo as credenciais do usuário.
 */
public class AuthRequest {

    /** Email do usuário para autenticação */
    private String email;

    /** Senha do usuário para autenticação */
    private String senha;

    /**
     * Retorna o email do usuário.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     * @param email email a ser definido
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna a senha do usuário.
     * @return senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     * @param senha senha a ser definida
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
