package it.epicode.devices.controllers;

import it.epicode.devices.controllers.exceptions.BadRequestException;
import it.epicode.devices.controllers.exceptions.DispositivoNonDisponibileException;
import it.epicode.devices.controllers.exceptions.DispositivoNotFoundException;
import it.epicode.devices.controllers.models.DispositiviRequest;
import it.epicode.devices.entities.Dispositivi;
import it.epicode.devices.services.DispositiviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {

    @Autowired
    private DispositiviService dispositivi;

    @PostMapping
    public ResponseEntity<Dispositivi> saveDispositivi(@Validated @RequestBody DispositiviRequest request, BindingResult validator) {
        if(validator.hasErrors()){
            throw new BadRequestException(validator.getAllErrors());
        }
        Dispositivi salva = dispositivi.save(request);
        return ResponseEntity.ok(salva);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Dispositivi>updateDispositivi(@PathVariable Long id, @Validated @RequestBody DispositiviRequest request, BindingResult validator) {
        if(validator.hasErrors()){
            throw new DispositivoNotFoundException(validator.getAllErrors());
        }
        Dispositivi update = dispositivi.update(id,request);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivi> getDispositiviBiId(@PathVariable Long id) {
        Dispositivi dispositivo = dispositivi.findById(id);
        if (dispositivo != null) {
            return ResponseEntity.ok(dispositivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity <List<Dispositivi>>getAllDipendenti(){
        List<Dispositivi> dispositives = dispositivi.getAll();
        return ResponseEntity.ok(dispositives);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteDispositivoById(@PathVariable Long id){
        dispositivi.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{idDipendente}/{idDispositivo}")
    public ResponseEntity<String> aggiungiDipendente(@PathVariable Long idDipendente, @PathVariable Long idDispositivo){
        try {
            Dispositivi dispositivo = dispositivi.assegnaDispositivo(idDipendente, idDispositivo);
            return ResponseEntity.ok(dispositivo);
        } catch(DispositivoNonDisponibileException e){
            String errorMessage = "Impossibile assegnare. " + e.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }



}
