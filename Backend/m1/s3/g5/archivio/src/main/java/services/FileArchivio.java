
package services;


import data.Catalogo;
import data.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class FileArchivio implements Archivio {

    // Logger per il tracciamento degli eventi
    private static final Logger logger = LoggerFactory.getLogger(FileArchivio.class);

    // Gestione dell'entità manager factory e dell'entità manager per la persistenza
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    protected EntityManager em = emf.createEntityManager();

    // File che simula il database, per esempio per operazioni non JPA
    private File f = new File("./catalogo.csv");

    // Metodo per salvare un'entità Catalogo nel database
    @Override
    public void save(Catalogo cat) {
        var t = em.getTransaction();
        t.begin();
        em.persist(cat); // Persiste l'oggetto nel database
        t.commit(); // Commit della transazione
    }

    // Metodo vuoto, probabilmente per futura implementazione
    @Override
    public void add(Catalogo c) {

    }

    // Metodo per eliminare un catalogo basato sull'ISBN
    @Override
    public void deleteISBN(Integer ISBN) {
        try {
            Catalogo catalogo = em.find(Catalogo.class, ISBN); // Trova il catalogo per ISBN

            if (catalogo != null) {
                var t = em.getTransaction();
                t.begin();
                em.remove(catalogo); // Rimuove il catalogo dal database
                t.commit();
                logger.info("Catalogo con ISBN {} rimosso con successo", ISBN);
            } else {
                logger.warn("Nessun catalogo trovato con ISBN {}", ISBN);
            }
        } catch (Exception e) {
            logger.error("Errore durante la rimozione del catalogo con ISBN {}", ISBN, e);
        }
    }

    // Metodo per ottenere cataloghi basati sull'autore
    @Override
    public List<Catalogo> getByAutore(String autore) {
        try {
            var query = em.createNamedQuery("GET_AUTORE");
            query.setParameter("AUTORE", autore);
            List<Catalogo> result = query.getResultList();
            return result;
        } catch (Exception e) {
            logger.error("Elemento con autore specificato non esiste", e);
            return Collections.emptyList();
        }
    }

    // Metodo per ottenere cataloghi per anno di pubblicazione
    @Override
    public List<Catalogo> getAnno(Integer AnnoPubblicazione) {
        try {
            var query = em.createNamedQuery("GET_ANNO");
            query.setParameter("AnnoPubblicazione", AnnoPubblicazione);
            List<Catalogo> result = query.getResultList();
            return result;
        } catch (Exception e) {
            logger.error("Nessun libro uscito in questo anno nel catalogo", e);
            return null;
        }
    }

    // Metodo vuoto, probabilmente per futura implementazione
    @Override
    public void getAutore(String autore) {

    }

    // Metodo per ottenere cataloghi basati sul titolo
    @Override
    public List<Catalogo> getByTitolo(String titolo) {
        try {
            var query = em.createNamedQuery("GET_TITOLO", Catalogo.class);
            query.setParameter("titolo", titolo);
            List<Catalogo> result = query.getResultList();
            return result;
        } catch (Exception e) {
            logger.error("Errore durante la ricerca per titolo", e);
            return Collections.emptyList();
        }
    }

    // Metodo per ottenere elementi in prestito, non implementato
    @Override
    public List<Catalogo> getElementiInPrestito(Integer numeroTessera) {
        return List.of();
    }

    // Metodo per ottenere prestiti scaduti non restituiti, non implementato
    @Override
    public List<Prestito> getPrestitiScadutiNonRestituiti() {
        return List.of();
    }

    // Metodo per ottenere un catalogo per ISBN
    @Override
    public Optional<Catalogo> getISBN(Integer ISBN) {
        try {
            var query = em.createNamedQuery("GET_ISBN");
            query.setParameter("ISBN", ISBN);
            var cat = (Catalogo) query.getSingleResult();
            return Optional.of(cat);
        } catch (Exception e) {
            logger.error("Exception searching catalogo by id", e);
            return Optional.empty();
        }
    }
}
