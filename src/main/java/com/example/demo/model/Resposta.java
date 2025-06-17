package com.example.demo.model;

import jakarta.persistence.*;

/**
 * Representa uma resposta dada por um usuário para uma questão, vinculando uma alternativa escolhida.
 */
@Entity
public class Resposta {

    /** Identificador único da resposta */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Email do usuário que respondeu */
    private String usuarioEmail;

    /** Questão respondida */
    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    /** Alternativa escolhida para a questão */
    @ManyToOne
    @JoinColumn(name = "alternativa_id")
    private Alternativa alternativa;

    /**
     * Retorna o identificador único da resposta.
     * @return id da resposta
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único da resposta.
     * @param id identificador da resposta
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o email do usuário que respondeu.
     * @return email do usuário
     */
    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    /**
     * Define o email do usuário que respondeu.
     * @param usuarioEmail email do usuário
     */
    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    /**
     * Retorna a questão associada a essa resposta.
     * @return questão respondida
     */
    public Questao getQuestao() {
        return questao;
    }

    /**
     * Define a questão associada a essa resposta.
     * @param questao questão respondida
     */
    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    /**
     * Retorna a alternativa escolhida pelo usuário para a questão.
     * @return alternativa escolhida
     */
    public Alternativa getAlternativa() {
        return alternativa;
    }

    /**
     * Define a alternativa escolhida pelo usuário para a questão.
     * @param alternativa alternativa escolhida
     */
    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }
}
