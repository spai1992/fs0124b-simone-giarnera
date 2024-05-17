package it.epicode.eserciziovenerdi.entities;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name ="Simone")
    public Utente simoneBean() {
        return  Utente.builder()
                .withUsername("Spai")
                .withNome("Simone")
                .withCognome("Giarnera")
                .withEmail("simone.giarnera@gmail.com")
                .build();
    }

    @Bean(name = "Franco")
    public Utente francoBean() {
        return  Utente.builder()
                .withUsername("Frenk")
                .withNome("Franco")
                .withCognome("Rossi")
                .withEmail("franco.rossi@gmail.com")
                .build();
    }

    @Bean(name = "Palazzo1")
    public Edificio palazzo1Bean() {
        return  Edificio.builder()
               .withName("Palazzo1")
                .withIndirizzo("Piazza la bomba e scappa 1")
                .withCitta("Crotone")
               .build();
    }

    @Bean(name = "Palazzo2")
    public Edificio palazzo2Bean() {
        return  Edificio.builder()
                .withName("Palazzo2")
                .withIndirizzo("Via le mani dal naso 2")
                .withCitta("Reggio di Calabria")
                .build();
    }

    @Bean(name = "Postazione1")
    public Postazioni postazione1Bean() {
        return  Postazioni.builder()
               .withDescrizione("In rovina")
               .withTipo(TipoPostazione.PRIVATO)
               .withOccupantiMax(1)
               .withEdificio(palazzo1Bean())
               .build();
    }

    @Bean(name = "Postazione2")
    public Postazioni postazione2Bean() {
        return  Postazioni.builder()
                .withDescrizione("Fantastica")
                .withTipo(TipoPostazione.OPENSPACE)
                .withOccupantiMax(2)
                .withEdificio(palazzo2Bean())
                .build();
    }



}
