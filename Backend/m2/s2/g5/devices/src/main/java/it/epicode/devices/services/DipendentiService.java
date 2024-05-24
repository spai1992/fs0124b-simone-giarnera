package it.epicode.devices.services;

import it.epicode.devices.controllers.models.DipendentiRequest;
import it.epicode.devices.entities.Dipendenti;
import it.epicode.devices.repositories.DipendentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendentiService {
    @Autowired
    DipendentiRepository dipendenti;



    public Dipendenti save(DipendentiRequest d) {
        Dipendenti dipendente = new Dipendenti(
                d.username(),
                d.name(),
                d.cognome(),
                d.email()
        );
        return dipendenti.save(dipendente);
    }

    public Dipendenti findById(Long id) {
        dipendenti.findById(id);
        return null;
    }


    public Dipendenti delete(long id) {
        var c = dipendenti.findById(id);
        dipendenti.deleteById(id);
        return c.orElseThrow();

    }

    public List<Dipendenti> getAll() {
        return dipendenti.findAll();
    }

    public Dipendenti update(Long id, DipendentiRequest dipendente) {
       Dipendenti dipe = dipendenti.findById(id).orElseThrow(() -> new RuntimeException("Luca DIPE not found"));
dipe.setUsername(dipendente.username());
       dipe.setName(dipendente.name());
       dipe.setCognome(dipendente.cognome());
       dipe.setEmail(dipendente.email());

       return dipendenti.save(dipe);


    }


}
