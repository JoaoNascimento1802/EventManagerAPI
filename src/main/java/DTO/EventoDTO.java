package DTO;

import api.manager.senai.Entities.EntidadeEvento;

public class EventoDTO {
    private Long eventoId;
    private String nome;

    public EventoDTO(EntidadeEvento evento) {
        this.eventoId = evento.getEventoId();
        this.nome = evento.getNome();
        // Se não houver limite de vagas, pode retirar os campos relacionados
    }

    // Getters e Setters
    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
