package it.epicode.eserciziovenerdi.services;

import it.epicode.eserciziovenerdi.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {


    @Autowired
    UtenteRepository utente;
}
