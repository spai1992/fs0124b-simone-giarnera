package it.epicode.eventi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ruolo_id")
    private Ruoli ruolo;
    @OneToMany(mappedBy = "utente", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Evento> evento = new ArrayList<>();
}
