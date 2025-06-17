package com.example.demo.controller;

import com.example.demo.dto.TokenResponseDTO;
import com.example.demo.model.AuthRequest;
import com.example.demo.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável por autenticar usuários e gerar tokens JWT.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Realiza o login do usuário e retorna um token JWT.
     *
     * @param request Objeto contendo o e-mail e a senha do usuário
     * @return {@link ResponseEntity} com o token JWT caso a autenticação seja bem-sucedida
     */
    @Operation(summary = "Autentica o usuário e retorna um token JWT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso",
                    content = @Content(schema = @Schema(implementation = TokenResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas",
                    content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody AuthRequest request) {
        String token = authService.autenticar(request.getEmail(), request.getSenha());
        return ResponseEntity.ok(new TokenResponseDTO(token));
    }
}
