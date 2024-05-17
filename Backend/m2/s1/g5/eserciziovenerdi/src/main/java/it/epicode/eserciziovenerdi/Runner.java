package it.epicode.eserciziovenerdi;

import it.epicode.eserciziovenerdi.services.EdificioService;
import it.epicode.eserciziovenerdi.services.PostazioneService;
import it.epicode.eserciziovenerdi.services.PrenotazioneService;
import it.epicode.eserciziovenerdi.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteSrvice;
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;




    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EserciziovenerdiApplication.class);
    }
}
