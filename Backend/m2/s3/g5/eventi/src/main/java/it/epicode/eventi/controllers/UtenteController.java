package it.epicode.eventi.controllers;

import it.epicode.eventi.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteService utente;

}
