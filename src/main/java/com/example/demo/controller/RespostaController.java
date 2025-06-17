package com.example.demo.controller;

import com.example.demo.dto.RespostaDTO;
import com.example.demo.dto.RespostaResponseDTO;
import com.example.demo.model.Resposta;
import com.example.demo.service.RespostaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador responsável por processar as respostas dos usuários às questões.
 * Fornece endpoint para submissão de uma resposta vinculada a uma questão e alternativa.
 */
@RestController
@RequestMapping("/api/respostas")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    /**
     * Endpoint para registrar a resposta de um usuário a uma questão.
     * O e-mail do usuário é extraído do token JWT presente na requisição.
     *
     * @param dto     objeto contendo o ID da questão e da alternativa escolhida
     * @param request contexto da requisição HTTP, utilizado para obter o e-mail do usuário autenticado
     * @return {@link RespostaResponseDTO} com os dados da resposta criada
     */
    @Operation(
            summary = "Registra a resposta do usuário para uma questão",
            description = "Requer autenticação via JWT. O e-mail do usuário será extraído do token."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Resposta registrada com sucesso",
                    content = @Content(schema = @Schema(implementation = RespostaResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado", content = @Content)
    })
    @PostMapping
    public ResponseEntity<?> responderQuestao(@RequestBody RespostaDTO dto, HttpServletRequest request) {
        String usuarioEmail = (String) request.getUserPrincipal().getName();

        Resposta resposta = respostaService.salvarResposta(usuarioEmail, dto.getQuestaoId(), dto.getAlternativaId());

        RespostaResponseDTO responseDTO = new RespostaResponseDTO();
        responseDTO.setId(resposta.getId());
        responseDTO.setUsuarioEmail(usuarioEmail);
        responseDTO.setQuestaoEnunciado(resposta.getQuestao().getEnunciado());
        responseDTO.setAlternativaTexto(resposta.getAlternativa().getTexto());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
