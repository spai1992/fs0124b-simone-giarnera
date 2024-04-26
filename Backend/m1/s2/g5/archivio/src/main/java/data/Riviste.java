package data;

public class Riviste extends Catalogo {
    private Periodicita periodicita;

    public Riviste(int ISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}
