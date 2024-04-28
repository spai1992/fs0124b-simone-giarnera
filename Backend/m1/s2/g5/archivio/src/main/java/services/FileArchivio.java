package services;

import data.Catalogo;
import data.Libri;
import data.Periodicita;
import data.Riviste;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileArchivio implements Archivio {

    // Logger per tracciare le informazioni e gli errori
    private static final Logger logger = LoggerFactory.getLogger(FileArchivio.class);

    // Lista per memorizzare gli elementi del catalogo
    private ArrayList<Catalogo> lista = new ArrayList<>();
    // File che rappresenta il catalogo salvato su disco
    private File f = new File("./catalogo.csv");

    // Metodo per salvare gli elementi della lista nel file CSV
    public void save() {
        try {
            FileUtils.delete(f); // Cancella il file esistente prima di salvare i nuovi dati
        } catch (IOException err) {
            logger.error("Eccezione durante l'eliminazione", err); // Log dell'errore in caso di problemi nella cancellazione del file
        }
        lista.forEach(c -> {
            try {
                // Scrive i dati di libri o riviste nel file CSV con codifica ISO_8859_1
                if (c instanceof Libri) {
                    var lines = List.of(c.getISBN().toString() + "," + c.getTitolo() + "," + c.getAnnoPubblicazione() + "," + c.getNumeroPagine() + "," + ((Libri) c).getAutore() + "," + ((Libri) c).getGenere());
                    FileUtils.writeLines(f, StandardCharsets.ISO_8859_1.name(), lines, true);
                } else if (c instanceof Riviste) {
                    var lines = List.of(c.getISBN().toString() + "," + c.getTitolo() + "," + c.getAnnoPubblicazione() + "," + c.getNumeroPagine() + "," + ((Riviste) c).getPeriodicita());
                    FileUtils.writeLines(f, StandardCharsets.ISO_8859_1.name(), lines, true);
                }
            } catch (IOException e) {
                logger.error("Eccezione:", e); // Log dell'errore in caso di problemi nella scrittura del file
            }
        });
    }

    // Metodo per caricare i dati dal file CSV
    public void load() {
        leggiFile(f);
    }

    // Metodo per aggiungere un nuovo elemento al catalogo e salvarlo
    @Override
    public void add(Catalogo c) {
        lista.add(c);
        save();
    }

    // Metodo per eliminare un elemento dal catalogo in base all'ISBN e salvarlo
    @Override
    public void deleteISBN(Integer ISBN) {
        lista.removeIf(el -> el.getISBN().equals(ISBN));
        save();
    }

    // Metodo per ottenere un elemento del catalogo in base all'ISBN
    @Override
    public Optional<Catalogo> getByISBN(Integer ISBN) {
        return lista.stream().filter(el -> el.getISBN().equals(ISBN)).findFirst();
    }

    // Metodo per ottenere un elemento del catalogo in base all'anno di pubblicazione
    @Override
    public Optional<Catalogo> getAnno(Integer anno) {
        return lista.stream().filter(el -> el.getAnnoPubblicazione().equals(anno)).findFirst();
    }

    // Metodo per visualizzare tutti i libri di un autore specifico
    @Override
    public void getAutore(String autore) {
        lista.stream().filter(el -> el instanceof Libri && ((Libri) el).getAutore().equals(autore)).forEach(System.out::println);
    }

    // Metodo per ottenere tutti i libri di un autore specifico
    public List<Catalogo> getByAutore(String autore) {
        return lista.stream().filter(el -> el instanceof Libri && ((Libri) el).getAutore().equals(autore)).toList();
    }

    // Metodo per ottenere tutti gli elementi del catalogo di un certo anno di pubblicazione
    public List<Catalogo> getByAnno(Integer anno) {
        return lista.stream().filter(el -> el.getAnnoPubblicazione().equals(anno)).toList();
    }

    // Metodo per ottenere la lista attuale del catalogo
    public ArrayList<Catalogo> getLista() {
        return lista;
    }

    // Metodo per leggere e caricare i dati da un file CSV
    public List<String> leggiFile(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] el = line.split(",");
                String titolo = el[1];
                String annoPubblicazioneStr = el[2];
                String numeroPagineStr = el[3];
                int annoPubblicazione, numeroPagine;
                try {
                    annoPubblicazione = Integer.parseInt(annoPubblicazioneStr);
                    numeroPagine = Integer.parseInt(numeroPagineStr);
                } catch (NumberFormatException e) {
                    System.err.println("Errore di conversione: " + e.getMessage());
                    continue;
                }
                // Distingue tra libri e riviste e li aggiunge alla lista
                if (el.length == 5) {
                    String periodicitàStr = el[4];
                    Periodicita periodicita = Periodicita.valueOf(periodicitàStr);
                    var rivista = new Riviste(titolo, annoPubblicazione, numeroPagine, periodicita);
                    lista.add(rivista);
                } else if (el.length == 6) {
                    String autore = el[4];
                    String genere = el[5];
                    var libro = new Libri(titolo, annoPubblicazione, numeroPagine, autore, genere);
                    lista.add(libro);
                }
                lines.add(line); // Aggiunge la linea letta alla lista di linee
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
