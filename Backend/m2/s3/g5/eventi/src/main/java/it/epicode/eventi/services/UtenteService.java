package it.epicode.eventi.services;


import it.epicode.eventi.controllers.records.UtenteRequest;
import it.epicode.eventi.entities.Ruoli;
import it.epicode.eventi.entities.Utente;
import it.epicode.eventi.repositories.RuoliRepository;
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
    RuoliRepository ruoli;


    public Utente save(UtenteRequest u){
        Ruoli r = ruoli.findById(u.ruoloid()).orElseThrow(() -> new RuntimeException("ruolo non c'è"));
        var ut = Utente.builder().withNome(u.nome()).withRuolo(r).build();
        return utente.save(ut);
    }





}
