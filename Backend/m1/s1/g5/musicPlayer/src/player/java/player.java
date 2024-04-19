package player.java;

import java.util.Scanner;

public class player {

    // creo un nuovo array di media, in quale verranno inseriti oggetti con le proprietà specifiche per ogni media creato in precedenza
    // l'array avrà una lunghezza di 5, come richiesto dall'esercizio

    private media[] array = new media[5];

   // questo metodo serve per la creazione del programma vero e proprio, ciclando la lunghezza dell'array media
   // chiedo all'utente come prima istruzione, il tipo di media che vuole inserire (di tipo string), questo genererà differenti casi nello switch

    public  void insertData(){

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
        System.out.println("Inserisci il tipo di contenuto multimediale");
        String tipo = scanner.nextLine();
        switch(tipo){
            case "audio":
                System.out.println("Inserisci il titolo della traccia audio");
                String titolo = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Inserisci il volume che vuoi impostare");
                int volume = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci la durata della traccia");
                int durata = scanner.nextInt();
                scanner.nextLine();
                array[i] = new audio(titolo,volume,durata);
                break;

                case "video":
                    System.out.println("Inserisci il titolo del video");
                    String titolo2 = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Inserisci il volume che vuoi impostare");
                    int volume2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci la durata del video");
                    int durata2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci la luminosità del video");
                    int lum = scanner.nextInt();
                    scanner.nextLine();
                    array[i] = new video(titolo2,volume2,durata2,lum);
                    break;

            case "image":
                System.out.println("Inserisci il titolo dell'immagine");
                String titolo3 = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Inserisci la luminosità del immagine");
                int lum2 = scanner.nextInt();
                scanner.nextLine();
                array[i] = new image(titolo3,lum2);
                break;

            default:System.out.println("Hai inserito un media non accettato!!");


        }

    }

        // tramite questo do while chiedo all'utente quale media vuole riprodurre, scegliendo tra i 5 inseriti in precedenza
        // se l'utente preme 0 invece, termina il programma

        int i = 0;
 do {
     System.out.println("Inserisci un numero di contenuto multimediale");
     int elemento = scanner.nextInt();
     if (elemento == 0){
         break;
     }
     array[elemento].esegui();
     i++;

 }while (true);




    }





}


