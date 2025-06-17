package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * Data Transfer Object para criação de uma nova Questão.
 * Contém o enunciado da questão e uma lista de alternativas associadas.
 */
@Schema(description = "Objeto usado para criar uma nova questão com suas alternativas.")
public class QuestaoCreateDTO {

    /** Enunciado da questão */
    @Schema(description = "Texto do enunciado da questão", example = "Qual estilo de trabalho você prefere?")
    private String enunciado;

    /** Lista de alternativas disponíveis para essa questão */
    @Schema(description = "Lista de alternativas para a questão")
    private List<AlternativaDTO> alternativas;

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
