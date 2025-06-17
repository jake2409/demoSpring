package com.example.demo.dao;

import com.example.demo.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface para operações de persistência da entidade {@link Questao}.
 * Estende {@link JpaRepository} para fornecer operações CRUD básicas.
 *
 * Além disso, define um método customizado para buscar todas as questões com suas alternativas associadas,
 * evitando o problema de N+1 queries.
 */
@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {
    /**
     * Busca todas as questões, realizando fetch join para carregar as alternativas junto,
     * melhorando a performance ao evitar múltiplas consultas.
     *
     * @return lista de todas as questões com suas alternativas carregadas
     */
    @Query("SELECT q FROM Questao q LEFT JOIN FETCH q.alternativas")
    List<Questao> findAllWithAlternativas();

}
