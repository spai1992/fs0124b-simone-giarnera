package it.epicode.eventi.entities;

import it.epicode.eventi.enums.Ruoli;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "utenti")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Utente extends Base{
    private String nome;
    private Ruoli ruolo;
    @OneToMany(mappedBy = "utente")
    private List<Evento> evento;
}
