package it.epicode.devices.entities;

import it.epicode.devices.enums.StatoDispositivo;
import it.epicode.devices.enums.TipoDispositivo;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "dispositivi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")


public class Dispositivi extends Base {
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendenti dipendenti;
    private TipoDispositivo tipoDispositivo;
    private StatoDispositivo statoDispositivo;

    public Dispositivi(TipoDispositivo tipoDispositivo, StatoDispositivo statoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
        this.statoDispositivo = statoDispositivo;
    }
}
