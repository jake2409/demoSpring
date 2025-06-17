package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object para representar a resposta enviada ao cliente
 * após o salvamento de uma resposta, incluindo detalhes da resposta,
 * do usuário e da questão respondida.
 */
@Schema(description = "DTO de resposta enviada ao cliente após o salvamento de uma resposta.")
public class RespostaResponseDTO {

    /** Identificador único da resposta */
    @Schema(description = "ID único da resposta", example = "10")
    private Long id;

    /** Email do usuário que respondeu à questão */
    @Schema(description = "E-mail do usuário que respondeu à questão", example = "usuario@email.com")
    private String usuarioEmail;

    /** Enunciado da questão respondida */
    @Schema(description = "Enunciado da questão respondida", example = "Qual seu perfil de investimento?")
    private String questaoEnunciado;

    /** Texto da alternativa escolhida pelo usuário */
    @Schema(description = "Texto da alternativa escolhida pelo usuário", example = "Moderado")
    private String alternativaTexto;

    /**
     * Obtém o ID da resposta.
     * @return o ID da resposta
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID da resposta.
     * @param id o ID da resposta
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o email do usuário que respondeu.
     * @return o email do usuário
     */
    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    /**
     * Define o email do usuário que respondeu.
     * @param usuarioEmail o email do usuário
     */
    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    /**
     * Obtém o enunciado da questão respondida.
     * @return o enunciado da questão
     */
    public String getQuestaoEnunciado() {
        return questaoEnunciado;
    }

    /**
     * Define o enunciado da questão respondida.
     * @param questaoEnunciado o enunciado da questão
     */
    public void setQuestaoEnunciado(String questaoEnunciado) {
        this.questaoEnunciado = questaoEnunciado;
    }

    /**
     * Obtém o texto da alternativa escolhida.
     * @return o texto da alternativa
     */
    public String getAlternativaTexto() {
        return alternativaTexto;
    }

    /**
     * Define o texto da alternativa escolhida.
     * @param alternativaTexto o texto da alternativa
     */
    public void setAlternativaTexto(String alternativaTexto) {
        this.alternativaTexto = alternativaTexto;
    }
}
