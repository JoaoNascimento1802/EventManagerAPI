// api/manager/senai/DTO/EventoDTO.java
package api.manager.senai.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

import api.manager.senai.Entities.EntidadeEvento;

@Schema(description = "Modelo de dados para um Evento")
public class EventoDTO {

    @Schema(description = "ID único do evento", example = "1")
    private Long id;
    @Schema(description = "Nome do evento", example = "Hackathon de IA")
    private String nome;
    @Schema(description = "Descrição detalhada do evento", example = "Competição de programação com foco em inteligência artificial.")
    private String descricao;
    @Schema(description = "Data do evento (formato AAAA-MM-DD)", example = "2025-12-25")
    private LocalDate data;
    @Schema(description = "Local onde o evento será realizado", example = "Centro de Convenções")
    private String local;
    @Schema(description = "Número máximo de vagas disponíveis para o evento", example = "100")
    private int vagas;

    // Construtores, getters e setters (mantidos como estavam)
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