package it.epicode.devices.controllers.models;

import it.epicode.devices.entities.Dipendenti;
import it.epicode.devices.enums.StatoDispositivo;
import it.epicode.devices.enums.TipoDispositivo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DispositiviRequest(
        @NotNull(message = " DeviceType is required")
        TipoDispositivo tipoDispositivo,
        @NotNull(message = "DeviceStatus is required")
        StatoDispositivo statoDispositivo
        )
       {
}
