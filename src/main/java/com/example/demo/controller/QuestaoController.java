package com.example.demo.controller;

import com.example.demo.dto.QuestaoCreateDTO;
import com.example.demo.dto.QuestaoDTO;
import com.example.demo.service.QuestaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável por gerenciar questões.
 * Fornece endpoints para listar, buscar, criar, atualizar e deletar questões.
 */
@Tag(name = "Questão", description = "Operações relacionadas às questões")
@RestController
@RequestMapping("/api/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoService service;

    /**
     * Lista todas as questões cadastradas.
     *
     * @return lista de {@link QuestaoDTO}
     */
    @Operation(summary = "Listar todas as questões")
    @GetMapping
    public ResponseEntity<List<QuestaoDTO>> listarTodas() {
        return ResponseEntity.ok(service.getTodas());
    }

    /**
     * Busca uma questão específica pelo seu ID.
     *
     * @param id identificador da questão
     * @return {@link QuestaoDTO} correspondente ao ID informado
     */
    @Operation(summary = "Buscar questão por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Questão encontrada"),
            @ApiResponse(responseCode = "404", description = "Questão não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<QuestaoDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.getQuestao(id));
    }

    /**
     * Cria uma nova questão.
     *
     * @param dto dados da nova questão a ser criada
     * @return {@link QuestaoDTO} da questão criada com status 201 (CREATED)
     */
    @Operation(summary = "Criar uma nova questão")
    @PostMapping
    public ResponseEntity<QuestaoDTO> criar(@RequestBody QuestaoCreateDTO dto) {
        QuestaoDTO criada = service.criarQuestao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    /**
     * Atualiza uma questão existente.
     *
     * @param id  identificador da questão a ser atualizada
     * @param dto novos dados da questão
     * @return {@link QuestaoDTO} com os dados atualizados
     */
    @Operation(summary = "Atualiza uma questão")
    @PutMapping("/{id}")
    public ResponseEntity<QuestaoDTO> atualizar(@PathVariable Long id, @RequestBody QuestaoCreateDTO dto) {
        QuestaoDTO atualizada = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    /**
     * Deleta uma questão pelo seu ID.
     *
     * @param id identificador da questão a ser deletada
     * @return resposta sem conteúdo (HTTP 204)
     */
    @Operation(summary = "Deleta uma questão")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
}
