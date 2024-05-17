package it.epicode.eserciziovenerdi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "prenotazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Prenotazione extends Base {

    @OneToOne
    private Postazioni postazioni;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utenti;
    private LocalDate dataPrenotazione;
    private LocalDate dataScadenza;


    public Prenotazione(Long id, Postazioni postazioni, Utente utenti, LocalDate dataPrenotazione) {
        super(id);
        this.postazioni = postazioni;
        this.utenti = utenti;
        this.dataPrenotazione = dataPrenotazione;
        this.dataScadenza = dataPrenotazione.plusDays(1);
    }


}
