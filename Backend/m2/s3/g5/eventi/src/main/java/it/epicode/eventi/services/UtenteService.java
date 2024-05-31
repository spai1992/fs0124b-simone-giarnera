package it.epicode.eventi.services;


import it.epicode.eventi.controllers.records.UtenteRequest;
import it.epicode.eventi.entities.Ruoli;
import it.epicode.eventi.entities.Utente;
import it.epicode.eventi.repositories.Ruolirepository;
import it.epicode.eventi.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    UtenteRepository utente;
    @Autowired
    Ruolirepository ruoli;



    public Utente save(UtenteRequest u, Long idRuolo){
        var ruolo = ruoli.findById(idRuolo);
        Utente utente = new Utente(
        u.nome(),
        u.ruolo()
        );


    }


}
