package com.DBFirst.projetoEventos.service;

import java.util.List;

import com.DBFirst.projetoEventos.domain.entities.Participacao;
import com.DBFirst.projetoEventos.exeption.BusinessRuleFail;
import com.DBFirst.projetoEventos.repository.ParticipacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipacaoService {

    private final ParticipacaoRepository participacaoRepository;

    @Autowired
    public ParticipacaoService(ParticipacaoRepository participacaoRepository) {
        this.participacaoRepository = participacaoRepository;
    }

    public List<Participacao> listParticipantes() {
        return participacaoRepository.findAll();
    }

    public Participacao joinEvent(Participacao model) throws Throwable {
        int count = participacaoRepository.countParticipants(model.getEvento().getId());
        if (count < model.getEvento().getVagas()) {
            if (model.getEvento().getStatus().getId() == 1) {
                return participacaoRepository.save(model);
            }
            throw new BusinessRuleFail("Só é possivel se inscrever se o evento estiver aguardando inscrição");
        }
        throw new BusinessRuleFail("Todas as vagas já foram preenchidas");
    }
}
