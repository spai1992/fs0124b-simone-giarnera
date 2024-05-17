package it.epicode.eserciziovenerdi.services;

import it.epicode.eserciziovenerdi.Repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {

    @Autowired
    PostazioneRepository postazioni;
}
