package it.epicode.eserciziovenerdi.Repository;

import it.epicode.eserciziovenerdi.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
