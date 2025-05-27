package api.manager.senai.controllers;

import api.manager.senai.DTO.UsuarioDTO;
import api.manager.senai.Service.UsuarioService;

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
@RequestMapping("/api/usuario")
@Tag(name = "Usuários", description = "Operações relacionadas a usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os usuários", description = "Retorna uma lista de todos os usuários cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UsuarioDTO.class)))
    public List<UsuarioDTO> getUsuarios() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um usuário por ID", description = "Retorna os detalhes de um usuário específico pelo ID.")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = UsuarioDTO.class)))
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<UsuarioDTO> getUsuarioPorId(
            @Parameter(description = "ID do usuário a ser buscado", required = true) @PathVariable Long id) {
        UsuarioDTO dto = usuarioService.buscarPorId(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Cria um novo usuário", description = "Cadastra um novo usuário no sistema.")
    @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso",
            content = @Content(schema = @Schema(implementation = UsuarioDTO.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos para o usuário")
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO dto) {
        return usuarioService.criar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um usuário existente", description = "Atualiza os dados de um usuário específico pelo ID.")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
            content = @Content(schema = @Schema(implementation = UsuarioDTO.class)))
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(
            @Parameter(description = "ID do usuário a ser atualizado", required = true) @PathVariable Long id,
            @RequestBody UsuarioDTO dto) {
        UsuarioDTO atualizado = usuarioService.atualizar(id, dto);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um usuário", description = "Remove um usuário do sistema pelo ID.")
    @ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<Void> deletarUsuario(
            @Parameter(description = "ID do usuário a ser excluído", required = true) @PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}