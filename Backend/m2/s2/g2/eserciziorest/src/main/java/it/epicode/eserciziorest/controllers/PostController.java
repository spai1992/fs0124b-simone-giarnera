package it.epicode.eserciziorest.controllers;

import it.epicode.eserciziorest.services.PostServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/post")


public class PostController {


    @Autowired
    PostServiceImp service;

}
