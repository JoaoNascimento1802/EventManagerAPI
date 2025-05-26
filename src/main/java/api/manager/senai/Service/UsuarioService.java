
package api.manager.senai.Service;

import api.manager.senai.DTO.UsuarioDTO;
import api.manager.senai.Entities.EntidadeUsuario;
import api.manager.senai.Repository.UsuarioRepository;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;

    public UsuarioService(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public UsuarioDTO criar(UsuarioDTO dto) {
        EntidadeUsuario u = new EntidadeUsuario();
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setTelefone(dto.getTelefone());
        u = usuarioRepo.save(u);
        return new UsuarioDTO(u);
    }
}
