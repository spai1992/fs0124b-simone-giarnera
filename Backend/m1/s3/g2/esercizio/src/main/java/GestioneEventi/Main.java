package GestioneEventi;

import Eventi.FileEventoDAO;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        final Logger log = LoggerFactory.getLogger(FileEventoDAO.class);

        final ArrayList<Evento> lista = new ArrayList<>();
        final String PERSISTENCE_UNIT_NAME = "postgres";

        Evento evento1 = new Evento(1, "ciao", LocalDate.of(2023, 1, 1), "prova", EventoT.PRIVATO, 2);
        Evento evento2 = new Evento(2, "Party", LocalDate.of(2021, 1, 1), "festa", EventoT.PUBBLICO, 2);
        Evento evento3 = new Evento(3, "Festa", LocalDate.of(2024, 1, 1), "festa", EventoT.PUBBLICO, 2);
        Evento evento4 = new Evento(4, "Rave", LocalDate.of(2022, 1, 1), "Bordello", EventoT.PUBBLICO, 2);


        lista.add(evento1);
        lista.add(evento2);
        lista.add(evento3);
        lista.add(evento4);
        try {

            var emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            var em = emf.createEntityManager();
            var transizione = em.getTransaction();
            transizione.begin();
            lista.forEach(c -> {
                em.merge(c);
                log.debug("Salvati {}", c);
            });
            transizione.commit();
            em.close();
            emf.close();
        } catch (Exception e) {
            log.error("Hai sbagliato", e);


        }
    }
}
