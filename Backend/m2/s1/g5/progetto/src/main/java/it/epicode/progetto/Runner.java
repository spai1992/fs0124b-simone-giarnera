package it.epicode.progetto;

import it.epicode.progetto.entities.AppConfig;
import it.epicode.progetto.entities.TipoPostazione;
import it.epicode.progetto.services.EdificioService;
import it.epicode.progetto.services.PostazioneService;
import it.epicode.progetto.services.PrenotazioneService;
import it.epicode.progetto.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class Runner implements CommandLineRunner {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    PostazioneService postazioneService;
    @Autowired
    EdificioService edificioService;

    @Autowired
    AppConfig appConfig;



    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        try{
            var utente1 = appConfig.simoneBean();
            var utente2 = appConfig.francoBean();
            utenteService.save(utente1);
            utenteService.save(utente2);
            var edificio1 = appConfig.palazzo1Bean();
            var edificio2 = appConfig.palazzo2Bean();
            edificioService.save(edificio1);
            edificioService.save(edificio2);
            var postazione1 = appConfig.postazione1Bean();
            var postazione2 = appConfig.postazione2Bean();
            postazioneService.save(postazione1);
            postazioneService.save(postazione2);

            prenotazioneService.crea(1L,utente1, LocalDate.now());
            //prova che non posso prenotare per lo stesso giorno
            prenotazioneService.crea(2L,utente1, LocalDate.now());

            //cerca postazione per tipo e città
            postazioneService.cercaPostazione(TipoPostazione.OPENSPACE,"Roma");

        }catch (Exception ex) {
            System.err.println(ex.getMessage());
        }




    }
}
