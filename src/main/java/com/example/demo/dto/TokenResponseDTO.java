package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object que encapsula o token JWT gerado após
 * a autenticação do usuário.
 */
@Schema(description = "DTO que encapsula o token JWT gerado após autenticação.")
public class TokenResponseDTO {

    /** Token JWT gerado para o usuário autenticado */
    @Schema(description = "Token JWT gerado para o usuário autenticado", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

    /**
     * Construtor que inicializa o DTO com o token fornecido.
     *
     * @param token Token JWT gerado
     */
    public TokenResponseDTO(String token) {
        this.token = token;
    }

    /**
     * Obtém o token JWT.
     *
     * @return token JWT
     */
    public String getToken() {
        return token;
    }
}
