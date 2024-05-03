package data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Utente {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private long numeroDiTessera;


}
