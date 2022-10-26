package Exceptions;

public class productoExistenteException extends Exception{

    public productoExistenteException() {
        super("El producto ingresado ya esta en el sistema");
    }
}
