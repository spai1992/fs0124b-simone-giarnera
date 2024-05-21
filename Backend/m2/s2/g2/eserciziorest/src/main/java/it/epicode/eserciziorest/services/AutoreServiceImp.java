package it.epicode.eserciziorest.services;

import it.epicode.eserciziorest.entities.Autore;
import it.epicode.eserciziorest.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AutoreServiceImp {

    @Autowired
    private AutoreRepository autore;

    public Optional<Autore> save(Autore a){
        return Optional.of(autore.save(a));
    }

    public List<Autore> getAll(){
        return autore.findAll();

    }


    public Optional<Autore> cercaId(long id){

        return autore.findById(id);

    }




}
