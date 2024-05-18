package it.epicode.progetto.services;

import it.epicode.progetto.entities.Prenotazione;
import it.epicode.progetto.entities.Utente;
import it.epicode.progetto.repository.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class PrenotazioneService {


    @Autowired
    PrenotazioneRepository prenotazioniDao;

    @Autowired
    PostazioneService postazioneService;

    public Prenotazione save(Prenotazione prenotazione){
        return prenotazioniDao.save(prenotazione);
    }


    public void crea(Long postazioneId, Utente utente, LocalDate dataPrenotazione){
        var postazione = postazioneService.findById(postazioneId);
        if(postazione == null){
            log.warn("La postazione che stai cercando non esiste!");
        }else if((postazione.getOccupantiMax() - prenotazioniDao.findBydataPrenotazioneAndPostazioniId(dataPrenotazione, postazione.getId()).size()) == 0){
            log.warn("Non è possibile prenotare, posti esauriti per la data " + dataPrenotazione);
        }else if(prenotazioniDao.findBydataPrenotazioneAndUtentiId(dataPrenotazione, utente.getId()) != null ){
            log.warn("Non puoi prenotare per lo stesso giorno");

        }else{
            log.info("Prenotazione effettuata" );
            prenotazioniDao.save(new Prenotazione(postazione, utente, dataPrenotazione));

        }

    }
}