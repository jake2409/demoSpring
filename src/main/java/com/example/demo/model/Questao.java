package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa uma questão que possui um enunciado e várias alternativas.
 */
@Entity
@Table(name="questoes")
public class Questao {

    /** Identificador único da questão */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Texto do enunciado da questão */
    private String enunciado;

    /**
     * Lista de alternativas associadas a essa questão.
     */
    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Alternativa> alternativas;

    /**
     * Retorna a lista de alternativas associadas a essa questão.
     * @return lista de alternativas
     */
    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    /**
     * Define a lista de alternativas para essa questão.
     * @param alternativas lista de alternativas
     */
    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    /**
     * Retorna o enunciado da questão.
     * @return enunciado
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Define o enunciado da questão.
     * @param enunciado texto do enunciado
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * Retorna o identificador único da questão.
     * @return id da questão
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único da questão.
     * @param id identificador
     */
    public void setId(Long id) {
        this.id = id;
    }
}
