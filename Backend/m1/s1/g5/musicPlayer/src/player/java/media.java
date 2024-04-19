package player.java;

public abstract class media {

    // Questa è la nostra classe Genitore, astratta, in quanto l'elemento in comune tra tutti i nostri media (Classi figlie)
    // sarà solamente il titolo del media stesso.


protected String titolo;

public media(String titolo) {

    this.titolo = titolo;
}

public abstract void esegui();





}
