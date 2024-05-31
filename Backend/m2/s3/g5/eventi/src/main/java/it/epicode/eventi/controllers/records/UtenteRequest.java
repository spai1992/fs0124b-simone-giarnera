package it.epicode.eventi.controllers.records;

import it.epicode.eventi.entities.Ruoli;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UtenteRequest(
        @NotBlank
        @NotNull(message = "Il nome è obbligatorio")
        String nome,
        @NotEmpty
        @NotNull(message = "Il ruolo è obbligatorio")
        Ruoli ruolo

) {
}
