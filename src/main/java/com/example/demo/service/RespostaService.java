package com.example.demo.service;

import com.example.demo.dao.AlternativaRepository;
import com.example.demo.dao.QuestaoRepository;
import com.example.demo.dao.RespostaRepository;
import com.example.demo.model.Alternativa;
import com.example.demo.model.Questao;
import com.example.demo.model.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável por operações relacionadas às respostas dadas pelos usuários,
 * como salvar uma resposta vinculando um usuário, uma questão e uma alternativa.
 */
@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private QuestaoRepository questaoRepository;

    @Autowired
    private AlternativaRepository alternativaRepository;

    /**
     * Salva uma nova resposta para uma questão específica,
     * associando o email do usuário, a questão e a alternativa selecionada.
     *
     * @param usuarioEmail Email do usuário que respondeu.
     * @param questaoId ID da questão respondida.
     * @param alternativaId ID da alternativa escolhida.
     * @return A entidade Resposta persistida.
     * @throws RuntimeException se a questão ou alternativa não forem encontrados.
     */
    public Resposta salvarResposta(String usuarioEmail, Long questaoId, Long alternativaId) {
        Optional<Questao> questaoOpt = questaoRepository.findById(questaoId);
        Optional<Alternativa> alternativaOpt = alternativaRepository.findById(alternativaId);

        if (questaoOpt.isEmpty() || alternativaOpt.isEmpty()) {
            throw new RuntimeException("Questão ou Alternativa não encontrados");
        }

        Resposta resposta = new Resposta();
        resposta.setUsuarioEmail(usuarioEmail);
        resposta.setQuestao(questaoOpt.get());
        resposta.setAlternativa(alternativaOpt.get());

        return respostaRepository.save(resposta);
    }
}
