package data;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Prestito {
    private Utente utente;
    private  List<Catalogo> elementoPrestato = new ArrayList<>();
    private LocalDate dataInizioPrestito
}
