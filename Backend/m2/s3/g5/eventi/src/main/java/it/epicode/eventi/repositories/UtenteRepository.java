package it.epicode.eventi.repositories;

import it.epicode.eventi.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
