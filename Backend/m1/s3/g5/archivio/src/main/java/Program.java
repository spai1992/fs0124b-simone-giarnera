import data.Libri;
import data.Riviste;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import services.FileArchivio;

public class Program {
    // Creazione di un logger per il monitoraggio degli eventi del programma
    Logger logger = LoggerFactory.getLogger(Program.class);

    // Metodo principale del programma che viene eseguito all'avvio
    public static void main(String[] args) {
        // Creazione di un'istanza del gestore di archiviazione file
        var FileArchivio = new FileArchivio();

        // Creazione di istanze di libri con diversi dettagli
        Libri libri1 = new Libri("Viaggio oltre i confini", 2003, 2345, "Lucia", "fantasy");
        Libri libri2 = new Libri("Notte stellata", 1998, 5823, "Giovanni", "romanzo");
        Libri libri3 = new Libri("Le onde del destino", 2010, 3674, "Francesca", "avventura");
        Libri libri4 = new Libri("Sussurri del bosco", 2001, 4829, "Roberto", "mistero");
        Libri libri5 = new Libri("Il mistero della cripta", 2015, 8301, "Elena", "thriller");
        Libri libri6 = new Libri("Risveglio primaverile", 1992, 4490, "Matteo", "drammatico");

        // Salvataggio degli oggetti libri nel sistema di archiviazione file
        FileArchivio.save(libri1);
        FileArchivio.save(libri2);
        FileArchivio.save(libri3);
        FileArchivio.save(libri4);
        FileArchivio.save(libri5);

        // Rimozione di libri dal sistema di archiviazione usando un identificativo ISBN specifico
        FileArchivio.deleteISBN(2);
        FileArchivio.deleteISBN(4);

        // Stampa delle informazioni di un libro basate sul titolo cercato
        System.out.println(FileArchivio.getByTitolo("onde"));

        // Stampa delle informazioni di un libro non presente, per verificare il comportamento del sistema
        System.out.println(FileArchivio.getByTitolo("Harry"));
    }
}
