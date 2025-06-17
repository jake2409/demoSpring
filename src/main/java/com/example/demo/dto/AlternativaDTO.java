package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object para representar uma Alternativa.
 * Contém os dados básicos da alternativa como id, texto e perfil.
 */
@Schema(description = "DTO que representa uma alternativa de uma questão.")
public class AlternativaDTO {

    /** Identificador único da alternativa */
    @Schema(description = "Identificador único da alternativa", example = "1")
    private Long id;

    /** Texto descritivo da alternativa */
    @Schema(description = "Texto descritivo da alternativa", example = "Sou mais analítico do que criativo")
    private String texto;

    /** Perfil associado à alternativa */
    @Schema(description = "Perfil associado à alternativa", example = "leve")
    private String perfil;

    /**
     * Obtém o ID da alternativa.
     * @return id da alternativa
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID da alternativa.
     * @param id id a ser definido
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o texto da alternativa.
     * @return texto da alternativa
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Define o texto da alternativa.
     * @param texto texto a ser definido
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Obtém o perfil associado à alternativa.
     * @return perfil da alternativa
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * Define o perfil da alternativa.
     * @param perfil perfil a ser definido
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
