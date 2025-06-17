package com.example.demo.factory;

import com.example.demo.dto.AlternativaDTO;
import com.example.demo.dto.QuestaoCreateDTO;
import com.example.demo.dto.QuestaoDTO;
import com.example.demo.model.Alternativa;
import com.example.demo.model.Questao;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Fábrica para converter entre entidades Questao e seus respectivos DTOs.
 *
 * Fornece métodos para:
 * - Converter uma entidade Questao em QuestaoDTO para resposta via API.
 * - Converter um QuestaoCreateDTO em uma entidade Questao para persistência.
 */
public class QuestaoFactory {

    /**
     * Converte uma entidade Questao em um QuestaoDTO.
     *
     * @param questao Entidade Questao a ser convertida
     * @return QuestaoDTO representando a entidade Questao
     */
    public static QuestaoDTO toDTO(Questao questao) {
        QuestaoDTO dto = new QuestaoDTO();
        dto.setId(questao.getId());
        dto.setEnunciado(questao.getEnunciado());

        List<AlternativaDTO> alternativas = questao.getAlternativas().stream()
                .map(a -> {
                    AlternativaDTO adto = new AlternativaDTO();
                    adto.setId(a.getId());
                    adto.setTexto(a.getTexto());
                    adto.setPerfil(a.getPerfil());
                    return adto;
                })
                .collect(Collectors.toList());

        dto.setAlternativas(alternativas);

        return dto;
    }

    /**
     * Converte um QuestaoCreateDTO em uma entidade Questao.
     *
     * @param dto DTO contendo dados para criação de uma Questao
     * @return Entidade Questao pronta para persistência
     */
    public static Questao fromCreateDTO(QuestaoCreateDTO dto) {
        Questao questao = new Questao();
        questao.setEnunciado(dto.getEnunciado());

        if (dto.getAlternativas() != null) {
            List<Alternativa> alternativas = dto.getAlternativas().stream().map(altDto -> {
                Alternativa alt = new Alternativa();
                alt.setTexto(altDto.getTexto());
                alt.setPerfil(altDto.getPerfil());
                alt.setQuestao(questao);
                return alt;
            }).toList();
            questao.setAlternativas(alternativas);
        }

        return questao;
    }
}
