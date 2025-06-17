package com.example.demo.dao;

import com.example.demo.model.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável por operações de persistência da entidade {@link Alternativa}.
 * Estende {@link JpaRepository}, fornecendo métodos padrão para CRUD.
 */
@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Long> {}
