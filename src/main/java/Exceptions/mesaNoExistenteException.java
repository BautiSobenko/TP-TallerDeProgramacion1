package Exceptions;

public class mesaNoExistenteException extends Exception{
    public mesaNoExistenteException() {
        super("La mesa ingresada no existe en el sistema");
    }
}
