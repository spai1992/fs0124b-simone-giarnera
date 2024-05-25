package it.epicode.devices.controllers.exceptions;

public class DispositivoNonDisponibileException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DispositivoNonDisponibileException(String message) {
        super(message);
    }


}
