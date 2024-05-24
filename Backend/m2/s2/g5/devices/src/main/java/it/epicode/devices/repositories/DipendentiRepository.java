package it.epicode.devices.repositories;

import it.epicode.devices.entities.Dipendenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DipendentiRepository extends JpaRepository<Dipendenti, Long> {
}
