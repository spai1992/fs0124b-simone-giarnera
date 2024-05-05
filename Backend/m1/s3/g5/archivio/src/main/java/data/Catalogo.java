
package data;


import jakarta.persistence.*;

// Annotazione @Entity indica che questa classe è un'entità JPA
@Entity

// Annotazione @Inheritance specifica la strategia di ereditarietà dei tavoli per le classi derivate
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

// Annotazione @DiscriminatorColumn definisce una colonna discriminatoria per distinguere tra diversi tipi di elementi nel catalogo
@DiscriminatorColumn(name = "Elemento_catalogo", discriminatorType = DiscriminatorType.STRING)

// Annotazioni @NamedQuery per predefinire query per il recupero di informazioni specifiche
@NamedQuery(name = "GET_ISBN", query = "SELECT c FROM Catalogo c WHERE c.ISBN = :ISBN")
@NamedQuery(name = "GET_ANNO", query = "SELECT c FROM Catalogo c WHERE c.annoPubblicazione = :AnnoPubblicazione")
@NamedQuery(name = "GET_AUTORE", query = "SELECT c FROM Catalogo c WHERE c.autore = :AUTORE")
@NamedQuery(name = "GET_TITOLO", query = "SELECT c FROM Catalogo c WHERE c.titolo LIKE CONCAT('%', :titolo, '%')")

// Definizione della classe astratta Catalogo
public abstract class Catalogo {
    // Campo ISBN con annotazioni per la gestione della chiave primaria e la generazione automatica del valore
    @Id
    @GeneratedValue
    private Integer ISBN;

    // Attributi base di un catalogo
    private String titolo;
    private Integer annoPubblicazione;
    private Integer numeroPagine;

    // Override del metodo toString per fornire una rappresentazione testuale dell'oggetto Catalogo
    @Override
    public String toString() {
        return "Catalogo{" +
                "ISBN=" + getISBN() +
                ", titolo='" + getTitolo() + '\'' +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", numeroPagine=" + getNumeroPagine() +
                '}';
    }

    // Costruttore con parametri per inizializzare un oggetto Catalogo
    public Catalogo(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    // Costruttore vuoto utilizzato da JPA per creare istanze di entità
    public Catalogo() {}

    // Metodi getter e setter per ogni campo dell'entità
    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
