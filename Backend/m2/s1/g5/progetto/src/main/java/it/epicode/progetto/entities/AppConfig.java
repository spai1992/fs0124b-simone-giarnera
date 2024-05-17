package it.epicode.progetto.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean(name="Simone")
    public Utente simoneBean(){
        return Utente.builder()
                .withUsername("Spai")
                .withNome("Simone")
                .withCognome("Giarnera")
                .withEmail("simone.giarnera@gmail.com")
                .build();
    }

    @Bean(name = "Franco")
    public Utente francoBean(){
        return  Utente.builder()
                .withUsername("Frenk")
                .withNome("Franco")
                .withCognome("Rossi")
                .withEmail("franco@gmail.it")
                .build();
    }

    @Bean(name="Palazzo1")
    public Edificio palazzo1Bean(){
        return Edificio.builder()
                .withName("Palazzo1")
                .withCitta("Milano")
                .withIndirizzo("Via le mani dal naso1")
                .build();
    }

    @Bean(name = "Palazzo2")
    public Edificio palazzo2Bean(){
        return Edificio.builder()
                .withName("Palazzo2")
                .withCitta("Roma")
                .withIndirizzo("Piazza la bomba e scappa2")
                .build();
    }

    @Bean(name = "Postazione1")
    public Postazioni postazione1Bean(){
        return Postazioni.builder()
                .withDescrizione("in rovina")
                .withTipo(TipoPostazione.OPENSPACE)
                .withOccupantiMax(1)
                .withEdificio(palazzo1Bean())
                .build();
    }

    @Bean(name = "Postazione2")
    public Postazioni postazione2Bean(){
        return Postazioni.builder()
                .withOccupantiMax(2)
                .withTipo(TipoPostazione.RIUNIONE)
                .withDescrizione("leggendaria")
                .withEdificio(palazzo2Bean())
                .build();
    }




}