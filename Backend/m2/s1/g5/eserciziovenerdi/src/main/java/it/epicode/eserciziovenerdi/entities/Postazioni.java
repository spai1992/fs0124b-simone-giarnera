package it.epicode.eserciziovenerdi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "postazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Postazioni extends Base {
    private String descrizione;
    private TipoPostazione tipo;
    private Long occupantiMax;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
}
