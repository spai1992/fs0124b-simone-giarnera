package it.epicode.eventi.controllers;


import it.epicode.eventi.controllers.records.EventoRequest;

import it.epicode.eventi.entities.Evento;

import it.epicode.eventi.services.EventoService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/evento")
public class EventoController {


    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<Evento> saveEvento(@Validated @RequestBody EventoRequest request, BindingResult validator) throws BadRequestException {
        if (validator.hasErrors()) {
            throw new BadRequestException(String.valueOf(validator.getAllErrors()));
        }

        return ResponseEntity.ok(eventoService.save(request));
    }
}
