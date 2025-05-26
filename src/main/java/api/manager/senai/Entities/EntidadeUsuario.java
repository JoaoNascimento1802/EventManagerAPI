package api.manager.senai.Entities;


import jakarta.persistence.*;

@Entity
@Table( name = "tb_usuarios")
public class EntidadeUsuario {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long usuarioId;
    private String email;
    private String nome;
    private String telefone;

    public EntidadeUsuario() {
    }

    public EntidadeUsuario(Long usuarioId, String email, String nome, String telefone) {
        this.usuarioId = usuarioId;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
