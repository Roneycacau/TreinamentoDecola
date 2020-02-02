package com.DBFirst.projetoEventos.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.DBFirst.projetoEventos.domain.dto.response.EventoResponseById;
import com.DBFirst.projetoEventos.domain.entities.CategoriaEvento;
import com.DBFirst.projetoEventos.domain.entities.Evento;
import com.DBFirst.projetoEventos.exeption.BusinessRuleFail;
import com.DBFirst.projetoEventos.exeption.DataNotFoundException;
import com.DBFirst.projetoEventos.mapper.EventoMapper;
import com.DBFirst.projetoEventos.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final StatusEventoService eventoStatusService;
    private final EventoMapper mapper;

    @Autowired
    public EventoService(EventoRepository eventoRepository, StatusEventoService eventoStatusService,
            EventoMapper mapper) {
        this.eventoRepository = eventoRepository;
        this.eventoStatusService = eventoStatusService;
        this.mapper = mapper;
    }

    public List<Evento> listEventos() {
        return eventoRepository.findAll();
    }

    public Evento createEvent(Evento model) {
        return eventoRepository.save(model);
    }

    public Evento findById(Integer id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.orElseThrow(() -> new DataNotFoundException("Evento não encontrado"));
    }

    public Evento updatEvento(Evento evento) throws DataNotFoundException {
        Evento currentEvento = findById(evento.getId());
        currentEvento.setDescricao(evento.getDescricao());
        currentEvento.setInicio(evento.getInicio());
        currentEvento.setFim(evento.getFim());
        currentEvento.setNome(evento.getNome());
        currentEvento.setVagas(evento.getVagas());
        currentEvento.setLocal(evento.getLocal());
        currentEvento.setCategoria(evento.getCategoria());
        return eventoRepository.save(currentEvento);
    }

    public Boolean compareDateInZeroHour(Date date) {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        Calendar event = Calendar.getInstance();
        event.setTime(date);
        event.set(Calendar.HOUR, 0);
        event.set(Calendar.MINUTE, 0);
        event.set(Calendar.SECOND, 0);
        event.set(Calendar.MILLISECOND, 0);
        return today.equals(event);
    }

    public Evento deleteEvento(Integer id) {
        Evento currentEvento = findById(id);

        if (!compareDateInZeroHour(currentEvento.getInicio()) && currentEvento.getStatus().getId() < 3) {
            currentEvento.setStatus(eventoStatusService.findById(4));

            return eventoRepository.save(currentEvento);
        } else {
            Optional<Evento> evento = eventoRepository.findById(0);
            return evento.orElseThrow(() -> new DataNotFoundException(
                    "Evento não pode ser cancelado no mesmo dia que a data Inicio. E apenas se ainda estiver Aberto"));
        }
    }

    public Evento startEvento(Integer id) {
        Evento currentEvento = findById(id);
        if (compareDateInZeroHour(currentEvento.getInicio()) && currentEvento.getStatus().getId() == 1) {
            currentEvento.setStatus(eventoStatusService.findById(4));
            currentEvento.setStatus(eventoStatusService.findById(2));
            return eventoRepository.save(currentEvento);
        } else {
            throw new BusinessRuleFail(
                    "O evento só pode ser iniciado no mesmo dia da Data de Inicio E apenas se ainda estiver Aberto");
        }
    }

    public Evento endEvento(Integer id) {
        Evento currentEvento = findById(id);
        if (compareDateInZeroHour(currentEvento.getInicio()) && currentEvento.getStatus().getId() == 2) {
            currentEvento.setStatus(eventoStatusService.findById(3));
            return eventoRepository.save(currentEvento);
        } else {
            throw new BusinessRuleFail("O evento só pode ser concluido se tiver sido iniciado");
        }
    }

    public List<String> listParticipants(Integer id) {
        return eventoRepository.listParticipants(id);
    }

    public List<Evento> lisByCategoria(Integer categoria) {
        CategoriaEvento category = new CategoriaEvento();
        category.setId(categoria);
        return eventoRepository.findByCategoria(category);
    }

    public EventoResponseById listEvenDetails(Integer id) {
        EventoResponseById response = new EventoResponseById();
        Evento evento = findById(id);
        response.setEvento(mapper.toDto(evento));
        response.setParticipantes(this.listParticipants(evento.getId()));
        return response;

    }
}