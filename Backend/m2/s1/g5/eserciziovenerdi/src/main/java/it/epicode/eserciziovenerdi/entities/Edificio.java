package it.epicode.eserciziovenerdi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "edifici")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Edificio extends Base {

    private String name;
    private String indirizzo;
    private String citta;
    private List<Postazioni> postazioni;


}
