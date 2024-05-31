package it.epicode.eventi.repositories;

import it.epicode.eventi.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
