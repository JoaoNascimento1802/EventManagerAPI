package api.manager.senai.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_usuarios")
public class EntidadeUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column
    private String telefone;

    @JsonIgnore
    @ManyToMany(mappedBy = "participantes", fetch = FetchType.LAZY,
                cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<EntidadeEvento> eventos = new HashSet<>();

    public EntidadeUsuario() { }

    public EntidadeUsuario(Long id, String email, String nome, String telefone) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<EntidadeEvento> getEventos() {
        return eventos;
    }
    public void setEventos(Set<EntidadeEvento> eventos) {
        this.eventos = eventos;
    }
}
