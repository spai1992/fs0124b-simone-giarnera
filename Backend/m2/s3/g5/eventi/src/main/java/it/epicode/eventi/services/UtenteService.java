package it.epicode.eventi.services;


import it.epicode.eventi.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    UtenteRepository utente;
}
