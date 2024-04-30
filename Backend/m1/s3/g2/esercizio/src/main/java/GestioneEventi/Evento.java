package GestioneEventi;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "eventi")
public class Evento {
@Id

    @GeneratedValue(strategy = GenerationType.AUTO)
private long id;
    @Column(length = 10, nullable = false)
    private String titolo;
    @Column(nullable = false)
    private LocalDate dataEvento;
    private String descrizione;
    private EventoT tipoEvento;
    private long numeroMassimoPartecipanti;

    public Evento() {

    }

    public Evento(long id, String titolo, LocalDate dataEvento, String descrizione, EventoT tipoEvento, long numeroMassimoPartecipanti) {
        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventoT getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(EventoT tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public long getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(long numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
}
