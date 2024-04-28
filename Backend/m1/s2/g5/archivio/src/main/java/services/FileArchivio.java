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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FileArchivio implements Archivio {

    private static final Logger logger = LoggerFactory.getLogger(FileArchivio.class);

    private ArrayList<Catalogo> lista = new ArrayList<>();
    private File f = new File("./catalogo.csv");

    public void save() {
        try {
            FileUtils.delete(f);
        } catch (IOException err) {
            IOException e = err;
            logger.error("Eccezione durante l'eliminazione", e);
        }
        lista.forEach(c -> {
            try {
                if (c instanceof Libri) {
                    // Se l'elemento è un libro, scrivi le informazioni del libro nel file
                    var lines = List.of(c.getISBN().toString() + "," + c.getTitolo() + "," + c.getAnnoPubblicazione() + "," + c.getNumeroPagine() + "," + ((Libri) c).getAutore() + "," + ((Libri) c).getGenere());
                    FileUtils.writeLines(f, StandardCharsets.ISO_8859_1.name(), lines, true);

                } else if (c instanceof Riviste) {
                    // Se l'elemento è una rivista, scrivi le informazioni della rivista nel file
                    var lines = List.of(c.getISBN().toString() + "," + c.getTitolo() + "," + c.getAnnoPubblicazione() + "," + c.getNumeroPagine() + "," + ((Riviste) c).getPeriodicita());
                    FileUtils.writeLines(f, StandardCharsets.ISO_8859_1.name(), lines, true);
                }

            } catch (IOException e) {
                logger.error("Eccezione:", e);
            }
        });
    }

    // Metodo per caricare la lista degli elementi dal file
    public void load() {
        leggiFile(f);
    }


    @Override
    public void add(Catalogo c) {
        lista.add(c);
        save();

    }

    @Override
    public void deleteISBN(Integer ISBN) {
        lista.removeIf(el -> el.getISBN().equals(ISBN));
        save();

    }

    @Override
    public Optional<Catalogo> getByISBN(Integer ISBN) {
        return lista.stream().filter(el -> el.getISBN().equals(ISBN)).findFirst();
    }

    @Override
    public Optional<Catalogo> getAnno(Integer anno) {
        return lista.stream().filter(el -> el.getAnnoPubblicazione().equals(anno)).findFirst();
    }

    @Override
    public void getAutore(String autore) {
        lista.stream().filter(el -> el instanceof Libri && ((Libri) el).getAutore().equals(autore)).forEach(System.out::println);
    }

    public List<Catalogo> getByAutore(String autore) {
        return lista.stream().filter(el -> el instanceof Libri && ((Libri) el).getAutore().equals(autore)).toList();
    }

    public List<Catalogo> getByAnno(Integer anno) {
        return lista.stream().filter(el -> el.getAnnoPubblicazione().equals(anno)).toList();
    }

    public ArrayList<Catalogo> getLista() {
        return lista;
    }

    public List<String> leggiFile(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] el = line.split(",");
                String titolo = el[1];
                String annoPubblicazioneStr = el[2];
                String numeroPagineStr = el[3];
                int annoPubblicazione;
                int numeroPagine;
                try {
                    annoPubblicazione = Integer.parseInt(annoPubblicazioneStr);
                    numeroPagine = Integer.parseInt(numeroPagineStr);
                } catch (NumberFormatException e) {
                    System.err.println("Errore di conversione: " + e.getMessage());
                    continue;
                }
                if (el.length == 5) {
                    // Se la lunghezza è 5, l'elemento è una rivista
                    String periodicitàStr = el[4];
                    Periodicita periodicita = Periodicita.valueOf(periodicitàStr);
                    var rivista = new Riviste(titolo, annoPubblicazione, numeroPagine, periodicita);
                    lista.add(rivista);
                } else if (el.length == 6) {
                    // Se la lunghezza è 6, l'elemento è un libro
                    String autore = el[4];
                    String genere = el[5];
                    var libro = new Libri(titolo, annoPubblicazione, numeroPagine, autore, genere);
                    lista.add(libro);
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}

