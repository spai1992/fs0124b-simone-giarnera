
package data;

// Importazione delle classi Entity e DiscriminatorValue per la gestione della persistenza degli oggetti
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Annotazione @Entity indica che questa classe è un'entità JPA
@Entity

// Annotazione @DiscriminatorValue specifica il valore discriminatore per questa classe quando parte di una gerarchia di ereditarietà
@DiscriminatorValue("Libro")

// Definizione della classe Libri che estende la classe Catalogo
public class Libri extends Catalogo {

    // Campi aggiuntivi specifici per i libri, ovvero autore e genere
    private String autore;
    private String genere;

    // Costruttore che accetta titolo, anno di pubblicazione, numero di pagine, autore e genere
    public Libri(String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore, String genere) {

        super(titolo, annoPubblicazione, numeroPagine); // Chiamata al costruttore della classe superiore

        this.autore = autore; // Impostazione dell'autore del libro

        this.genere = genere; // Impostazione del genere del libro
    }

    // Costruttore vuoto, utilizzato da JPA per la creazione di istanze di entità
    public Libri() {

    }

    // Metodi getter e setter per gli attributi autore e genere
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    // Metodo toString sovrascritto per fornire una rappresentazione testuale dell'oggetto Libri
    @Override
    public String toString() {
        return "Libri{" +
                "titolo='" + getTitolo() + '\'' +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
