import data.Libri;
import data.Periodicita;
import data.Riviste;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import services.FileArchivio;


public class Program {
    public static void main(String[] args) {

        FileArchivio archivio = new FileArchivio();

        // Aggiunge alcuni libri e riviste all'archivio
        Libri libro1 = new Libri("Educazione Siberiana", 1974, 320, "Audit", "Storico");
        Libri libro2 = new Libri("Harry Potter", 2003, 540, "J.K. Rowling", "Fantasy");
        Riviste rivista1 = new Riviste("National Geographic", 1888, 200, Periodicita.MENSILE);
        Riviste rivista2 = new Riviste("Scientific American", 1845, 150, Periodicita.SETTIMANALE);

        archivio.add(libro1);
        archivio.add(libro2);
        archivio.add(rivista1);
        archivio.add(rivista2);

        // Stampa l'archivio completo
        System.out.println("Archivio completo:");
        archivio.getLista().forEach(System.out::println);

        // Test della ricerca per ISBN
        System.out.println("\nRicerca per ISBN:");
        archivio.getByISBN(1).ifPresentOrElse(System.out::println, () -> System.out.println("Elemento non trovato"));

        // Test della ricerca per autore
        System.out.println("\nRicerca per autore:");
        archivio.getAutore("George Orwell");

        // Test della ricerca per anno di pubblicazione
        System.out.println("\nRicerca per anno di pubblicazione:");
        archivio.getByAnno(1949).forEach(System.out::println);

        // Test rimozione elemento
        archivio.deleteISBN(1);

        // Stampa archivio completo dopo eliminazione
        System.out.println("Archivio completo:");
        archivio.getLista().forEach(System.out::println);

    }
}
