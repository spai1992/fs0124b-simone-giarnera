package it.epicode.devices.controllers;


import it.epicode.devices.controllers.exceptions.BadRequestException;
import it.epicode.devices.controllers.exceptions.DipendenteNotFoundException;
import it.epicode.devices.controllers.models.DipendentiRequest;
import it.epicode.devices.entities.Dipendenti;
import it.epicode.devices.services.DipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")

public class DipendentiController {


    @Autowired
    private DipendentiService dipendenti;



    @PostMapping
    public ResponseEntity<Dipendenti>saveDipendenti(@Validated @RequestBody DipendentiRequest request, BindingResult validator) {
        if(validator.hasErrors()){
            throw new BadRequestException(validator.getAllErrors());
        }
        Dipendenti salva = dipendenti.save(request);
        return ResponseEntity.ok(salva);
    }


@PutMapping("/{id}")
    public ResponseEntity<Dipendenti>updateDipendenti(@PathVariable Long id, @Validated @RequestBody DipendentiRequest request, BindingResult validator) {
    if(validator.hasErrors()){
        throw new DipendenteNotFoundException(validator.getAllErrors());
    }
        Dipendenti update = dipendenti.update(id,request);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendenti> getDipendentiBiId(@PathVariable Long id) {
        Dipendenti dipendente = dipendenti.findById(id);
        if (dipendente != null) {
            return ResponseEntity.ok(dipendente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity <List<Dipendenti>>getAllDipendenti(){
        List<Dipendenti> dipendentis = dipendenti.getAll();
        return ResponseEntity.ok(dipendentis);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteDipendenteById(@PathVariable Long id){
        dipendenti.delete(id);
        return ResponseEntity.noContent().build();
    }

}
