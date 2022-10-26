package Exceptions;

public class mesaExistenteException extends Exception{

    public mesaExistenteException() {
        super("La mesa ingresada ya esta en el sistema");
    }
}
