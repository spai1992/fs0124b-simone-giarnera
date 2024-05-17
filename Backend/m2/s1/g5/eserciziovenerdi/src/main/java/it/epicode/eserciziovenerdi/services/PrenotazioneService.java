package it.epicode.eserciziovenerdi.services;

import it.epicode.eserciziovenerdi.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {

 @Autowired
    PrenotazioneRepository prenotazioni;
}
