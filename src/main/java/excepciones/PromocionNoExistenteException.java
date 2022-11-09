package excepciones;

public class PromocionNoExistenteException extends Exception{
    public PromocionNoExistenteException(){
        super("La promocion ingresada no se encuentra cargada en el sistema");
    }
}
