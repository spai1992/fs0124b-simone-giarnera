package it.epicode.devices.services;

import it.epicode.devices.controllers.models.DispositiviRequest;
import it.epicode.devices.entities.Dipendenti;
import it.epicode.devices.entities.Dispositivi;
import it.epicode.devices.repositories.DispositiviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositiviService {

    @Autowired
    DispositiviRepository dispositivi;
    @Autowired
    DipendentiService dipendente;


    public Dispositivi save(DispositiviRequest d){
        Dispositivi dispositivo = new Dispositivi(

                d.tipoDispositivo(),
                d.statoDispositivo()
        );
        return dispositivi.save(dispositivo);
    }
    public Dispositivi findById(Long id){
        var d = dispositivi.findById(id);
        return d.orElseThrow();
    }

    public Dispositivi delete (Long id){
        var c = dispositivi.findById(id);
        dispositivi.deleteById(id);
        return c.orElseThrow();
    }

    public List<Dispositivi> getAll(){
        return dispositivi.findAll();
    }


    public Dispositivi update(Long id, DispositiviRequest d){
        Dispositivi disp = dispositivi.findById(id).orElseThrow(() -> new RuntimeException("Dispositivo not found"));

        disp.setTipoDispositivo(d.tipoDispositivo());
        disp.setStatoDispositivo(d.statoDispositivo());

        return dispositivi.save(disp);
    }

    public Dispositivi assegnaDispositivo(Long idDipendente, Long idDispositivo){
        Dipendenti dipendenti = dipendente.findById(idDipendente);
        Dispositivi dispositivo = dispositivi.findById(idDispositivo).orElseThrow();

    }


}
