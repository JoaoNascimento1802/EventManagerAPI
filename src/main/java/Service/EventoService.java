package Service;

import Repository.EventoRepository;
import Repository.UsuarioRepository;
import api.manager.senai.Entities.EntidadeEvento;
import api.manager.senai.Entities.EntidadeUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String inscreverUsuarioEmEvento(Long usuarioId, Long eventoId) {
        Optional<EntidadeUsuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        Optional<EntidadeEvento> eventoOpt = eventoRepository.findById(eventoId);

        if (usuarioOpt.isEmpty() || eventoOpt.isEmpty()) {
            return "Usuário ou evento não encontrado.";
        }

        EntidadeUsuario usuario = usuarioOpt.get();
        EntidadeEvento evento = eventoOpt.get();

        if (evento.getParticipantes().contains(usuario)) {
            return "Usuário já está inscrito neste evento.";
        }

        // Removido o código de verificação de limite de vagas

        evento.getParticipantes().add(usuario);
        eventoRepository.save(evento);

        return "Inscrição realizada com sucesso.";
    }

    public String cancelarInscricao(Long usuarioId, Long eventoId) {
        Optional<EntidadeUsuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        Optional<EntidadeEvento> eventoOpt = eventoRepository.findById(eventoId);

        if (usuarioOpt.isEmpty() || eventoOpt.isEmpty()) {
            return "Usuário ou evento não encontrado.";
        }

        EntidadeUsuario usuario = usuarioOpt.get();
        EntidadeEvento evento = eventoOpt.get();

        if (!evento.getParticipantes().contains(usuario)) {
            return "Usuário não está inscrito neste evento.";
        }

        evento.getParticipantes().remove(usuario);
        eventoRepository.save(evento);

        return "Inscrição cancelada com sucesso.";
    }
}
