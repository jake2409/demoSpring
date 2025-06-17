package com.example.demo.service;

import com.example.demo.dto.QuestaoCreateDTO;
import com.example.demo.dto.QuestaoDTO;
import com.example.demo.service.facade.QuestaoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável por operações relacionadas às questões,
 * incluindo criação, atualização, busca e exclusão.
 * Utiliza a camada de fachada (facade) para executar as operações.
 */
@Service
public class QuestaoService {

    @Autowired
    private QuestaoFacade facade;

    /**
     * Busca uma questão pelo seu ID.
     *
     * @param id Identificador da questão.
     * @return Dados da questão encontrada.
     */
    public QuestaoDTO getQuestao(Long id) {
        return facade.buscarPorId(id);
    }

    /**
     * Retorna todas as questões cadastradas.
     *
     * @return Lista com todas as questões.
     */
    public List<QuestaoDTO> getTodas() {
        return facade.listarTodas();
    }

    /**
     * Cria uma nova questão a partir dos dados recebidos.
     *
     * @param dto Dados para criação da questão.
     * @return Dados da questão criada.
     */
    public QuestaoDTO criarQuestao(QuestaoCreateDTO dto) {
        return facade.criarQuestao(dto);
    }

    /**
     * Atualiza uma questão existente pelo seu ID.
     *
     * @param id  Identificador da questão a ser atualizada.
     * @param dto Dados atualizados da questão.
     * @return Dados da questão atualizada.
     */
    public QuestaoDTO atualizar(Long id, QuestaoCreateDTO dto) {
        return facade.atualizar(id, dto);
    }

    /**
     * Remove uma questão pelo seu ID.
     *
     * @param id Identificador da questão a ser deletada.
     */
    public void deletar(Long id) {
        facade.deletarPorId(id);
    }
}
