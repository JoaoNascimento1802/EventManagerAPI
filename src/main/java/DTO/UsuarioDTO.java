package DTO;

import api.manager.senai.Entities.EntidadeUsuario;

public class UsuarioDTO {
    private Long usuarioId;
    private String nome;
    private String email;
    private String telefone;

    // Construtor
    public UsuarioDTO(EntidadeUsuario usuario) {
        this.usuarioId = usuario.getUsuarioId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
    }

    // Getters e Setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
