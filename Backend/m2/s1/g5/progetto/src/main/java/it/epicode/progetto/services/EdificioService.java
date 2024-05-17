package it.epicode.progetto.services;

import it.epicode.progetto.entities.Edificio;
import it.epicode.progetto.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EdificioService {


    @Autowired
    EdificioRepository edificioDao;

    public void save(Edificio edificio){edificioDao.save(edificio);}
}
