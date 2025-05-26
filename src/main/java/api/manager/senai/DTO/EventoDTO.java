// src/main/java/api/manager/senai/dto/EventoDTO.java
package api.manager.senai.DTO;

import java.time.LocalDate;

import api.manager.senai.Entities.EntidadeEvento;

public class EventoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDate data;
    private String local;
    private int vagas;

    public EventoDTO() { }

    public EventoDTO(EntidadeEvento e) {
        this.id = e.getId();
        this.nome = e.getNome();
        this.descricao = e.getDescricao();
        this.data = e.getData();
        this.local = e.getLocal();
        this.vagas = e.getVagas();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public int getVagas() {
        return vagas;
    }
    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}
