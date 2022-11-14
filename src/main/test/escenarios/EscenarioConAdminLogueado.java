package escenarios;

import enums.EstadoMesa;
import excepciones.ContrasenaIncorrectaException;
import excepciones.UsuarioIncorrectoException;
import modelo.Empresa;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Producto;

public class EscenarioConAdminLogueado {

    Empresa empresa;
    Producto prod;
    Mesa mesa;
    Mozo mozo;

    public EscenarioConAdminLogueado( ) {
        this.empresa = Empresa.getEmpresa();
    }

    public void aplicaEscenarioConAdminLogueado() {

        try {
            empresa.login("admin", "admin1234");
        } catch (UsuarioIncorrectoException | ContrasenaIncorrectaException ignored) {
        }

        this.mozo = new Mozo("Juan", "28/08/2000", 2);

        this.mesa = new Mesa(10, 5);
        mesa.setEstadoMesa(EstadoMesa.LIBRE);
        mesa.setMozoAsignado(mozo);

        this.prod = new Producto("Morcilla",90,25,30);

        this.empresa.getProductos().add(prod);
        this.empresa.getMesas().add(mesa);
        this.empresa.getMozos().add(mozo);

    }

    public void borrarEscenario(){
        empresa.getProductos().remove(this.prod);
        empresa.getMesas().remove(this.mesa);
        empresa.getMozos().remove(this.mozo);
        empresa.logout();
    }

    public Producto getProd() {
        return prod;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Mozo getMozo() {
        return mozo;
    }
}
