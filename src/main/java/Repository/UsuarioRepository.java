package Repository;

import api.manager.senai.Entities.EntidadeUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<EntidadeUsuario, Long> {
}
