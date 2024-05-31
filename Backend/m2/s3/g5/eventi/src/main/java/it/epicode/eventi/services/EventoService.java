package it.epicode.eventi.services;


import it.epicode.eventi.repositories.EventoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventoService {


    @Autowired
    EventoRepository evento;

}
