package it.epicode.eserciziorest.controllers;


import it.epicode.eserciziorest.services.AutoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/autore")
public class AutoreController {

    @Autowired
    AutoreServiceImp service;

}
