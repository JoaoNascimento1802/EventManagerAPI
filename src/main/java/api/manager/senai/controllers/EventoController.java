
package api.manager.senai.controllers;

import api.manager.senai.DTO.EventoDTO;
import api.manager.senai.DTO.UsuarioDTO;
import api.manager.senai.Service.EventoService;
import api.manager.senai.Service.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoService eventoService;
    private final UsuarioService usuarioService;

    public EventoController(EventoService eventoService, UsuarioService usuarioService) {
        this.eventoService = eventoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public EventoDTO criarEvento(@RequestBody EventoDTO dto) {
        return eventoService.criar(dto);
    }

    @GetMapping
    public List<EventoDTO> listarEventos() {
        return eventoService.listar();
    }

    @PutMapping("/{id}")
    public EventoDTO atualizarEvento(@PathVariable Long id, @RequestBody EventoDTO dto) {
        return eventoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEvento(@PathVariable Long id) {
        eventoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/usuarios")
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO dto) {
        return usuarioService.criar(dto);
    }

    @PostMapping("/{eventoId}/inscrever/{usuarioId}")
    public ResponseEntity<Void> inscrever(@PathVariable Long eventoId, @PathVariable Long usuarioId) {
        eventoService.inscrever(eventoId, usuarioId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{eventoId}/cancelar/{usuarioId}")
    public ResponseEntity<Void> cancelar(@PathVariable Long eventoId, @PathVariable Long usuarioId) {
        eventoService.cancelar(eventoId, usuarioId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{eventoId}/participantes")
    public List<UsuarioDTO> participantes(@PathVariable Long eventoId) {
        return eventoService.participantes(eventoId);
    }
}
