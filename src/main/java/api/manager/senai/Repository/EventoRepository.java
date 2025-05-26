package api.manager.senai.Repository;

import api.manager.senai.Entities.EntidadeEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<EntidadeEvento, Long> {
}
