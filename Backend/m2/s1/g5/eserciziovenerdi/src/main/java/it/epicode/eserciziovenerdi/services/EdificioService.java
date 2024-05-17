package it.epicode.eserciziovenerdi.services;

import it.epicode.eserciziovenerdi.Repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {

    @Autowired
    EdificioRepository edificio;
}
