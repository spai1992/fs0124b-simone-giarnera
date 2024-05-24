package it.epicode.devices.controllers.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DipendentiRequest(
        @NotNull(message = "Username is required")
        String username,
        @NotNull(message = "Name is required")
        String name,
        @NotNull(message = "Surname is required")
        String cognome,
        @NotNull(message = "Email is required")
        @Email(message = "Email is not valid")
        String email)
 {
}
