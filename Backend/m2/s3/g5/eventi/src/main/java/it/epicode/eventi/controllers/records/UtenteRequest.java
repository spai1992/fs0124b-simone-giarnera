package it.epicode.eventi.controllers.records;

import it.epicode.eventi.entities.Ruoli;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UtenteRequest(
        @NotBlank
        @NotNull(message = "Nome è obbligatorio")
        String nome,
        @NotNull(message = "Email obbligatoria")
        String email,
        @NotNull(message = "Password è obbligatoria")
        String password,
        @NotNull(message = "Ruolo è obbligatorio")
        Long ruoloid) {
}