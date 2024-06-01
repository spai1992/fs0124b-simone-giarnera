package it.epicode.eventi.repositories;

import it.epicode.eventi.entities.Ruoli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuoliRepository extends JpaRepository<Ruoli, Long> {
}
