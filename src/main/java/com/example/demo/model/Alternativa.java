package com.example.demo.model;

import jakarta.persistence.*;

/**
 * Representa uma alternativa de resposta vinculada a uma questão.
 * Cada alternativa possui um texto, um perfil associado e referencia a questão a que pertence.
 */
@Entity
public class Alternativa {
    /** Identificador único da alternativa, gerado automaticamente */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Texto descritivo da alternativa */
    private String texto;

    /** Perfil associado à alternativa, ex: "leve", "moderado", "agressivo" */
    private String perfil;

    /** Relação muitos-para-um com a questão à qual essa alternativa pertence */
    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    /**
     * Retorna o identificador único da alternativa.
     * @return id da alternativa
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador da alternativa.
     * @param id id a ser definido
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o texto da alternativa.
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
     * Retorna o perfil associado à alternativa.
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

    /**
     * Retorna a questão associada a esta alternativa.
     * @return questão vinculada
     */
    public Questao getQuestao() {
        return questao;
    }

    /**
     * Define a questão associada a esta alternativa.
     * @param questao questão a ser vinculada
     */
    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}
