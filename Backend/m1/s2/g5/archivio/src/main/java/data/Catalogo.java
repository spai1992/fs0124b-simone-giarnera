package data;

public abstract class Catalogo {

    private static int nextISBN = 1;
    private  int ISBN;
    private String titolo;
    private int annoPubblicazione;
    private  int numeroPagine;

    public Catalogo(String titolo, int annoPubblicazione, int numeroPagine) {
        this.ISBN = nextISBN;
        nextISBN ++;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public static int getNextISBN() {
        return nextISBN;
    }

    public static void setNextISBN(int nextISBN) {
        Catalogo.nextISBN = nextISBN;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
