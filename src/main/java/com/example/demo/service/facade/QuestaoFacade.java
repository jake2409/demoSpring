package com.example.demo.service.facade;

import com.example.demo.dao.QuestaoRepository;
import com.example.demo.dto.QuestaoCreateDTO;
import com.example.demo.dto.QuestaoDTO;
import com.example.demo.factory.QuestaoFactory;
import com.example.demo.model.Alternativa;
import com.example.demo.model.Questao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestaoFacade {
    @Autowired
    private QuestaoRepository repository;

    public QuestaoDTO buscarPorId(Long id) {
        Questao questao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Questão não encontrada"));
        return QuestaoFactory.toDTO(questao);
    }

    public List<QuestaoDTO> listarTodas() {
        return repository.findAllWithAlternativas().stream()
                .map(QuestaoFactory::toDTO)
                .collect(Collectors.toList());
    }

    public QuestaoDTO criarQuestao(QuestaoCreateDTO dto) {
        Questao entidade = QuestaoFactory.fromCreateDTO(dto);
        Questao salva = repository.save(entidade);
        return QuestaoFactory.toDTO(salva);
    }

    public QuestaoDTO atualizar(Long id, QuestaoCreateDTO dto) {
        Questao existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Questão não encontrada"));

        existente.setEnunciado(dto.getEnunciado());

        existente.getAlternativas().clear();

        dto.getAlternativas().forEach(altDto -> {
            Alternativa alt = new Alternativa();
            alt.setTexto(altDto.getTexto());
            alt.setPerfil(altDto.getPerfil());
            alt.setQuestao(existente);
            existente.getAlternativas().add(alt);
        });

        Questao salva = repository.save(existente);

        return QuestaoFactory.toDTO(salva);
    }

    public void deletarPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Questão não encontrada");
        }
        repository.deleteById(id);
    }

}
