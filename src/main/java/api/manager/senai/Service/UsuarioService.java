package api.manager.senai.Service;

import api.manager.senai.DTO.UsuarioDTO;
import api.manager.senai.Entities.EntidadeUsuario;
import api.manager.senai.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepo.findAll().stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
    }

    public UsuarioDTO buscarPorId(Long id) {
        Optional<EntidadeUsuario> usuario = usuarioRepo.findById(id);
        return usuario.map(UsuarioDTO::new).orElse(null);
    }

    public UsuarioDTO atualizar(Long id, UsuarioDTO dto) {
        Optional<EntidadeUsuario> optional = usuarioRepo.findById(id);
        if (optional.isPresent()) {
            EntidadeUsuario u = optional.get();
            u.setNome(dto.getNome());
            u.setEmail(dto.getEmail());
            u.setTelefone(dto.getTelefone());
            u = usuarioRepo.save(u);
            return new UsuarioDTO(u);
        }
        return null;
    }

    public void deletar(Long id) {
        usuarioRepo.deleteById(id);
    }
}
