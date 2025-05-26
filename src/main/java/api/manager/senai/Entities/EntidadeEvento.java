package api.manager.senai.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_eventos")
public class EntidadeEvento {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long eventoId;
    private String nome;
    private LocalDate data;
    private int vagas;

    public EntidadeEvento() {
    }

    public EntidadeEvento(Long eventoId, String nome, LocalDate data, int vagas) {
        this.eventoId = eventoId;
        this.nome = nome;
        this.data = data;
        this.vagas = vagas;
    }

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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}
