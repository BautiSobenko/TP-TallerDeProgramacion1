package Exceptions;

public class productoNoExistenteException extends Exception{

    public productoNoExistenteException() {
        super("El producto ingresado no se encuentra en el sistema");
    }
}
