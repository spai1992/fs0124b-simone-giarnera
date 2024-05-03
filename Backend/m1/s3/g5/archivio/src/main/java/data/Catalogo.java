package data;

public abstract class Catalogo {

    private static Integer nextISBN = 1;
    private Integer ISBN;
    private String titolo;
    private Integer annoPubblicazione;
    private int numeroPagine;

    public Catalogo(String titolo, Integer annoPubblicazione, int numeroPagine) {
        this.ISBN = nextISBN;
        nextISBN++;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public static Integer getNextISBN() {
        return nextISBN;
    }

    public static void setNextISBN(Integer nextISBN) {
        Catalogo.nextISBN = nextISBN;
    }

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

    public void setAnno(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

}