package Exceptions;

public class operarioExistenteException extends Exception{

    public operarioExistenteException() {
        super("El operario ingresado ya esta en el sistema");
    }
}
