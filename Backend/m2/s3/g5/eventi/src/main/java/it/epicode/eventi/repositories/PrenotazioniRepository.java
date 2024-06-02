package it.epicode.eventi.repositories;

import it.epicode.eventi.entities.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Long> {

    Prenotazioni findByUtenteIdAndEventoId(Long idUtente, Long idEvento);

}
