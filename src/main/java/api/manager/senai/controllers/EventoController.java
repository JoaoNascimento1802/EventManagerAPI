package api.manager.senai.controllers;

import api.manager.senai.DTO.EventoDTO;
import api.manager.senai.DTO.UsuarioDTO;
import api.manager.senai.Service.EventoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@Tag(name = "Eventos", description = "Operações relacionadas a eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    @Operation(summary = "Cria um novo evento", description = "Cadastra um novo evento no sistema com os dados fornecidos.")
    @ApiResponse(responseCode = "200", description = "Evento criado com sucesso",
            content = @Content(schema = @Schema(implementation = EventoDTO.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos para o evento")
    public EventoDTO criarEvento(@RequestBody EventoDTO dto) {
        return eventoService.criar(dto);
    }

    @GetMapping
    @Operation(summary = "Lista todos os eventos", description = "Retorna uma lista de todos os eventos cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de eventos retornada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EventoDTO.class)))
    public List<EventoDTO> listarEventos() {
        return eventoService.listar();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um evento existente", description = "Atualiza os dados de um evento específico pelo ID.")
    @ApiResponse(responseCode = "200", description = "Evento atualizado com sucesso",
            content = @Content(schema = @Schema(implementation = EventoDTO.class)))
    @ApiResponse(responseCode = "404", description = "Evento não encontrado")
    public EventoDTO atualizarEvento(
            @Parameter(description = "ID do evento a ser atualizado", required = true) @PathVariable Long id,
            @RequestBody EventoDTO dto) {
        return eventoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um evento", description = "Remove um evento do sistema pelo ID.")
    @ApiResponse(responseCode = "204", description = "Evento excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Evento não encontrado")
    public ResponseEntity<Void> excluirEvento(
            @Parameter(description = "ID do evento a ser excluído", required = true) @PathVariable Long id) {
        eventoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{eventoId}/inscrever/{usuarioId}")
    @Operation(summary = "Inscreve um usuário em um evento", description = "Associa um usuário a um evento, inscrevendo-o como participante.")
    @ApiResponse(responseCode = "200", description = "Usuário inscrito com sucesso")
    @ApiResponse(responseCode = "404", description = "Evento ou usuário não encontrado")
    @ApiResponse(responseCode = "409", description = "Conflito: Sem vagas ou usuário já inscrito")
    public ResponseEntity<Void> inscrever(
            @Parameter(description = "ID do evento", required = true) @PathVariable Long eventoId,
            @Parameter(description = "ID do usuário", required = true) @PathVariable Long usuarioId) {
        eventoService.inscrever(eventoId, usuarioId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{eventoId}/cancelar/{usuarioId}")
    @Operation(summary = "Cancela a inscrição de um usuário em um evento", description = "Remove a associação de um usuário com um evento.")
    @ApiResponse(responseCode = "204", description = "Inscrição cancelada com sucesso")
    @ApiResponse(responseCode = "404", description = "Evento ou usuário não encontrado, ou usuário não estava inscrito")
    public ResponseEntity<Void> cancelar(
            @Parameter(description = "ID do evento", required = true) @PathVariable Long eventoId,
            @Parameter(description = "ID do usuário", required = true) @PathVariable Long usuarioId) {
        eventoService.cancelar(eventoId, usuarioId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{eventoId}/participantes")
    @Operation(summary = "Lista participantes de um evento", description = "Retorna todos os usuários inscritos em um evento específico.")
    @ApiResponse(responseCode = "200", description = "Lista de participantes retornada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UsuarioDTO.class)))
    @ApiResponse(responseCode = "404", description = "Evento não encontrado")
    public List<UsuarioDTO> participantes(
            @Parameter(description = "ID do evento", required = true) @PathVariable Long eventoId) {
        return eventoService.participantes(eventoId);
    }
}
