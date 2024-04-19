package program.java;

import player.java.audio;
import player.java.image;
import player.java.player;
import player.java.video;

public class program {

    // Un player multimediale deve riprodurre diversi tipi di Media
    // Ogni Media può essere Video, Audio, Image
    // Alcuni media possono essere riproducibili, alcuni hanno un volume ed una luminosità
    // Costruire un player che sia in grado di riprodurre i diversi media, con istruzioni differenti in base alla loro natura

    // -----------------------------------------------------------

    // Creiamo due interfacce, per suddividere le istruzioni tra i metodi riproducibili e non riproducibili

    // -----------------------------------------------------------

    // Interfaccia per Media Riproducibili:


    // Metodo play() => Riproduce il media
    // Metodo alzaVolume()
    // Metodo abbassaVolume()

    // -----------------------------------------------------------

    // Interfaccia per Media Non riproducibili (images):


    // Metodo alzaLuminosità()
    // Metodo abbassaLuminosità()
    // Metodo Show() => Mostra l'immagine




    public static void main(String[] args) {

        // qui ho fatto le prove per vedere se le classi funzionassero correttamente

        /*audio a = new audio("prova",5,7);
        a.esegui();
        a.alzaVolume();
        a.abbassaVolume();

       video v = new video("provavideo",2,8,3);
       v.esegui();
       v.alzaVolume();
       v.abbassaVolume();
       v.aumentaLuminosita();
       v.diminuisciLuminosita();


       image i = new image("provavideo",3);
       i.esegui();
       i.aumentaLuminosita();
       i.diminuisciLuminosita();


         */

// creo una nuova istanza di player e lancio il metodo insertData per far partire il programma

       player p = new player();
       p.insertData();


    }

}
