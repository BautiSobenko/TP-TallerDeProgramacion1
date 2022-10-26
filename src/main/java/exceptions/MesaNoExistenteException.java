package exceptions;

public class MesaNoExistenteException extends Exception{

    public MesaNoExistenteException() {
        super("La Mesa no se encuentra en el sistema");
    }
}
