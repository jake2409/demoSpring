package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object para representar uma resposta enviada pelo usuário,
 * contendo o ID da questão respondida e o ID da alternativa escolhida.
 */
@Schema(description = "Representa a resposta de um usuário com os IDs da questão e da alternativa escolhida.")
public class RespostaDTO {

    /** Identificador da questão respondida */
    @Schema(description = "ID da questão respondida", example = "1", required = true)
    private Long questaoId;

    /** Identificador da alternativa escolhida */
    @Schema(description = "ID da alternativa escolhida", example = "3", required = true)
    private Long alternativaId;

    /**
     * Obtém o ID da questão respondida.
     * @return o ID da questão
     */
    public Long getQuestaoId() {
        return questaoId;
    }

    /**
     * Define o ID da questão respondida.
     * @param questaoId o ID da questão
     */
    public void setQuestaoId(Long questaoId) {
        this.questaoId = questaoId;
    }

    /**
     * Obtém o ID da alternativa escolhida.
     * @return o ID da alternativa
     */
    public Long getAlternativaId() {
        return alternativaId;
    }

    /**
     * Define o ID da alternativa escolhida.
     * @param alternativaId o ID da alternativa
     */
    public void setAlternativaId(Long alternativaId) {
        this.alternativaId = alternativaId;
    }
}
