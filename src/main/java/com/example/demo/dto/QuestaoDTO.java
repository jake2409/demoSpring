package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * Data Transfer Object para representar uma Questão com seu ID, enunciado e lista de alternativas.
 * Usado para transferência de dados nas respostas da API.
 */
@Schema(description = "Representa uma questão com enunciado e lista de alternativas.")
public class QuestaoDTO {

    /** Identificador único da questão */
    @Schema(description = "Identificador único da questão", example = "1")
    private Long id;

    /** Enunciado da questão */
    @Schema(description = "Enunciado da questão", example = "Qual sua tolerância a riscos em investimentos?")
    private String enunciado;

    /** Lista de alternativas associadas à questão */
    @Schema(description = "Lista de alternativas associadas à questão")
    private List<AlternativaDTO> alternativas;

    /**
     * Obtém o ID da questão.
     * @return o ID da questão
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID da questão.
     * @param id o ID a ser definido
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o enunciado da questão.
     * @return o enunciado da questão
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Define o enunciado da questão.
     * @param enunciado o enunciado a ser definido
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * Obtém a lista de alternativas da questão.
     * @return lista de alternativas
     */
    public List<AlternativaDTO> getAlternativas() {
        return alternativas;
    }

    /**
     * Define a lista de alternativas da questão.
     * @param alternativas lista de alternativas a ser definida
     */
    public void setAlternativas(List<AlternativaDTO> alternativas) {
        this.alternativas = alternativas;
    }
}
