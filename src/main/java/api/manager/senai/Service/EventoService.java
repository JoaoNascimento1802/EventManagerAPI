// src/main/java/api/manager/senai/service/EventoService.java
package api.manager.senai.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.manager.senai.DTO.EventoDTO;
import api.manager.senai.DTO.UsuarioDTO;
import api.manager.senai.Entities.EntidadeEvento;
import api.manager.senai.Entities.EntidadeUsuario;
import api.manager.senai.Repository.EventoRepository;
import api.manager.senai.Repository.UsuarioRepository;

@Service
public class EventoService {

    private final EventoRepository eventoRepo;
    private final UsuarioRepository usuarioRepo;

    public EventoService(EventoRepository eventoRepo, UsuarioRepository usuarioRepo) {
        this.eventoRepo = eventoRepo;
        this.usuarioRepo = usuarioRepo;
    }

    public EventoDTO criar(EventoDTO dto) {
        EntidadeEvento e = new EntidadeEvento();
        e.setNome(dto.getNome());
        e.setDescricao(dto.getDescricao());
        e.setData(dto.getData());
        e.setLocal(dto.getLocal());
        e.setVagas(dto.getVagas());
        EntidadeEvento salvo = eventoRepo.save(e);
        return new EventoDTO(salvo);
    }

    public List<EventoDTO> listar() {
        return eventoRepo.findAll().stream()
            .map(EventoDTO::new)
            .collect(Collectors.toList());
    }

    public EventoDTO atualizar(Long id, EventoDTO dto) {
        EntidadeEvento e = eventoRepo.findById(id).orElseThrow();
        e.setNome(dto.getNome());
        e.setDescricao(dto.getDescricao());
        e.setData(dto.getData());
        e.setLocal(dto.getLocal());
        e.setVagas(dto.getVagas());
        EntidadeEvento atualizado = eventoRepo.save(e);
        return new EventoDTO(atualizado);
    }

    public void excluir(Long id) {
        eventoRepo.deleteById(id);
    }

    @Transactional
    public void inscrever(Long eventoId, Long usuarioId) {
        EntidadeEvento e = eventoRepo.findById(eventoId).orElseThrow();
        EntidadeUsuario u = usuarioRepo.findById(usuarioId).orElseThrow();
        if (e.getParticipantes().size() >= e.getVagas()) {
            throw new IllegalStateException("Sem vagas");
        }
        for (EntidadeUsuario participante : e.getParticipantes()) {
            if (participante.getId().equals(usuarioId)) {
                throw new IllegalStateException("Usuário já inscrito no evento");
            }
        }
        e.getParticipantes().add(u);
        u.getEventos().add(e);

    }

    @Transactional
    public void cancelar(Long eventoId, Long usuarioId) {
        EntidadeEvento e = eventoRepo.findById(eventoId).orElseThrow();
        EntidadeUsuario u = usuarioRepo.findById(usuarioId).orElseThrow();
        e.getParticipantes().remove(u);
        u.getEventos().remove(e);
    }

    @Transactional
    public List<UsuarioDTO> participantes(Long eventoId) {
        EntidadeEvento e = eventoRepo.findById(eventoId).orElseThrow();
        return e.getParticipantes().stream()
            .map(UsuarioDTO::new)
            .collect(Collectors.toList());
    }
}
