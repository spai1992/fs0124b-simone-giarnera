
package data;


import jakarta.persistence.Entity;

// Decoratore @Entity che indica che questa classe è un'entità JPA, pronta per la persistenza nel database
@Entity
public class Riviste extends Catalogo {
    // Dichiarazione di una variabile privata per la periodicità della rivista
    private Periodicita periodicita;

    // Costruttore che accetta titolo, anno di pubblicazione e numero di pagine, invocando il costruttore della classe base
    public Riviste(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
        super(titolo, annoPubblicazione, numeroPagine);
    }

    // Costruttore vuoto utilizzato da alcuni framework di persistenza come JPA per creare istanze di entità
    public Riviste() {
    }

    // Metodo getter per ottenere la periodicità della rivista
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    // Metodo setter per impostare la periodicità della rivista
    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    // Metodo toString sovrascritto per fornire una rappresentazione in stringa dell'oggetto Riviste
    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                '}';
    }
}
