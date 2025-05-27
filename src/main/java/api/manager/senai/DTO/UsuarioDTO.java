// api/manager/senai/DTO/UsuarioDTO.java
package api.manager.senai.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import api.manager.senai.Entities.EntidadeUsuario;

@Schema(description = "Modelo de dados para um Usuário")
public class UsuarioDTO {

    @Schema(description = "ID único do usuário", example = "1")
    private Long id;
    @Schema(description = "Nome completo do usuário", example = "Maria Silva")
    private String nome;
    @Schema(description = "Endereço de e-mail do usuário (único)", example = "maria.silva@example.com")
    private String email;
    @Schema(description = "Número de telefone do usuário", example = "5511987654321")
    private String telefone;


    public UsuarioDTO() { }

    public UsuarioDTO(EntidadeUsuario u) {
        this.id = u.getId();
        this.nome = u.getNome();
        this.email = u.getEmail();
        this.telefone = u.getTelefone();
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