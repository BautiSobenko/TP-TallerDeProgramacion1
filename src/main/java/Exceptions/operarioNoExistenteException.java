package Exceptions;

public class operarioNoExistenteException extends Exception{
    public operarioNoExistenteException() {
        super("El operario que se quiere modificar no existe");
    }
}
