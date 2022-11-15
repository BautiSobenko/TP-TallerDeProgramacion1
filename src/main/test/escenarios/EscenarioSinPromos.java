package escenarios;

import enums.Dias;
import modelo.Empresa;
import modelo.Producto;
import modelo.promociones.PromocionFija;
import modelo.promociones.PromocionTemporal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EscenarioSinPromos {

    Empresa empresa;
    Producto prod;
    PromocionFija promoFija;
    PromocionTemporal promocionTemporal;

    public void aplicarEscenarioSinPromos(){

        Set<PromocionFija> promosFijas = new HashSet<>();
        Set<PromocionTemporal> promosTemporales = new HashSet<>();


    }

    public void borrarEscenario(){
        empresa.getProductos().remove(this.prod);
        empresa.getPromocionesTemporales().remove(promocionTemporal);
        empresa.getPromocionesFijas().remove(promoFija);
    }

    public Producto getProd() {
        return prod;
    }

    public PromocionFija getPromoFija(){return promoFija;}

    public PromocionTemporal getPromoTemporal(){return  promocionTemporal;}


}
