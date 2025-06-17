package com.example.demo.dao;

import com.example.demo.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para operações de persistência da entidade {@link Resposta}.
 * Extende {@link JpaRepository} para fornecer métodos padrão de CRUD.
 */
@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {}
