package player.java;

public class audio extends media implements riproducibili {

    private int volume;
    private int durata;
    private static final int minimo = 0;
    private static final int massimo = 0;


    // creo il costruttore di audio, per importare tramite il super il titolo dalla classe astratta,

    public audio (String titolo, int volume, int durata) {

        super(titolo);
        this.volume = switchSegno(volume);
        setVolume(volume);
        this.durata = switchSegno(durata);

    }

    // Creo un metodo per cambiare il segno del valore

    public int switchSegno(int valore){
        if(valore < 0) valore = -valore;
        return valore;
    }

    // Creo un metodo impostare il volume


    private void setVolume(int volume) {
        if (volume >= minimo && volume <= massimo) {
            this.volume = volume;
        } else {
            System.out.println("Il volume deve essere compreso tra " + minimo + " e " + massimo);
        }
    }

    // Sovrascrivo tramite override il metodo play, che riprodurrà il media nel mio program

    @Override
    public void play() {
        String livelloVolume = "";

        for (int i=0; i<volume; i++) {
            livelloVolume += "!";
        };
        for (int i=0; i<durata; i++){
            System.out.println(titolo + ": " + livelloVolume);
        }

    }

    // Creo un metodo per alzare il volume tramite incremento

    @Override
    public void alzaVolume()  {
    if (volume < 10) {
        volume++;
        System.out.println("Volume alzato a " + volume);
    } else {
        System.out.println("Volume già al massimo");
    }
}

    // Creo un metodo per abbassare il volume tramite decremento


    @Override
    public void abbassaVolume() {
        if (volume > 0) {
        volume--;
        System.out.println("Volume abbassato a " + volume);
    } else {
        System.out.println("Volume già al minimo");
    }
}

// override sul metodo della classa astratta

    @Override
    public void esegui() {
        play();
    }
}
