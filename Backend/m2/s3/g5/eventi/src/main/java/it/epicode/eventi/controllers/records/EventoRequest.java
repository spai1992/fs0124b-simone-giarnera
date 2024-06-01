package it.epicode.eventi.controllers.records;

import it.epicode.eventi.enums.Luoghi;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EventoRequest(

        @NotNull(message = "Il nome dell'evento è obbligatorio")
        String titolo,
        @NotNull(message = "La descrizione è obbligatoria")
        String descrizione,
        @NotNull(message = "La data è obbligatoria")
        LocalDate data,
        @NotNull(message = "Il luogo dell'evento è obbligatorio")
        Luoghi luogo,
        @NotNull(message = "Il numero di posti è obbligatorio")
                @Min(value =1, message = "Il minimo dei posti è 1")
        int numeroPosti,
        @NotNull(message = "necessario")
        Long utenteid) {
}
