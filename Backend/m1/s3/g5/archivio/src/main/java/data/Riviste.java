package data;

public class Riviste extends Catalogo {
    private Periodicita periodicita;

    public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString() + "Riviste{" +
                "periodicita=" + periodicita +
                '}';
    }

}
