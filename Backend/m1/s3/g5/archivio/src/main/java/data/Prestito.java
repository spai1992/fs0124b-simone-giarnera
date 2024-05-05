package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Prestito {

    // Attributi privati che rappresentano i dettagli di un prestito
    private Long id; // ID del prestito
    private Utente utente; // Utente a cui è stato concesso il prestito
    private List<Catalogo> elementoPrestato = new ArrayList<>(); // Lista degli elementi prestati
    private LocalDate dataInizioPrestito; // Data di inizio del prestito
    private LocalDate dataFinePrestito = dataInizioPrestito.plusDays(30); // Data di fine prevista del prestito, impostata a 30 giorni dalla data di inizio
    private LocalDate dataRestituzioneEffettiva; // Data effettiva di restituzione degli elementi

    // Costruttore vuoto per la classe Prestito
    public Prestito() {
    }

    // Metodi getter e setter per ogni attributo della classe
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Catalogo> getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(List<Catalogo> elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataFinePrestito() {
        return dataFinePrestito;
    }

    public void setDataFinePrestito(LocalDate dataFinePrestito) {
        this.dataFinePrestito = dataFinePrestito;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    // Metodo toString sovrascritto per fornire una rappresentazione testuale dell'oggetto Prestito
    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataFinePrestito=" + dataFinePrestito +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
