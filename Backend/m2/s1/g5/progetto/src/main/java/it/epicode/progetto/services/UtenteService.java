package it.epicode.progetto.services;

import it.epicode.progetto.entities.AppConfig;
import it.epicode.progetto.entities.Utente;
import it.epicode.progetto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtenteService {


    @Autowired
    UtenteRepository utenteDao;


    public void save(Utente utente) {utenteDao.save(utente);}
}
