package it.epicode.eserciziovenerdi.Repository;

import it.epicode.eserciziovenerdi.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
}
