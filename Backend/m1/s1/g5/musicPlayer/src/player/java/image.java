package player.java;

public class image extends media implements visualizza {

    // inizializzo le variabili che mi serviranno per la classe image

    private int luminosità;
    private static final int minimol = 1;
    private static final int massimol = 5;


    // costruttore di image

    public image(String titolo, int luminosità) {
        super(titolo);
        this.luminosità = switchSegno(luminosità);
        setLumen(luminosità);
    }

    // metodo per il cambio del segno

    public int switchSegno(int valore){
        if(valore < 0) valore = -valore;
        return valore;
    }

    // metodo per settare un range di luminosità

    private void setLumen(int luminosità) {
        if (luminosità >= minimol && luminosità <= massimol) {
            this.luminosità = luminosità;
        } else {
            System.out.println("La luminosità deve essere compresa tra " + minimol + " e " + massimol);
        }
    }

    // metodo che utilizzerò per visualizzare una quantità di asterischi equivalente al livello di luminosità

    public void show() {
        String livelloLuminosità = "";

        for (int i=0; i<luminosità; i++) {
            livelloLuminosità += "*";

        }
        System.out.println(titolo + ": " + livelloLuminosità);
    }

    // richiamerò questo metodo in program, in modo tale che eseguirà show per quanto riguarda le immagini

    @Override
    public void esegui() {
        show();

    }

    @Override
    public void aumentaLuminosita() {
        if (luminosità < 5) {
            luminosità++;
            System.out.println("Luminosità alzata a " + luminosità);
        } else {
            System.out.println("Luminosità al massimo");
        }

    }

    @Override
    public void diminuisciLuminosita() {
        {

            if (luminosità > 1) {
                luminosità--;
                System.out.println("Luminosità abbassata a " + luminosità);
            } else {
                System.out.println("Luminosità già al minimo");
            }
        }

    }
}
