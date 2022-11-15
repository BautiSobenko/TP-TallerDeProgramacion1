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

    Set<PromocionFija> promosFijasViejas;

    Set<PromocionTemporal> promosTemporalesViejas;

    public void aplicarEscenarioSinPromos(){

        empresa = Empresa.getEmpresa();
        Set<PromocionFija> promosFijas = new HashSet<>();
        Set<PromocionTemporal> promosTemporales = new HashSet<>();

        promosFijasViejas = empresa.getPromocionesFijas();
        promosTemporalesViejas = empresa.getPromocionesTemporales();

        empresa.setPromocionesFijas(promosFijas);
        empresa.setPromocionesTemporales(promosTemporales);
    }

    public void borrarEscenario(){
        empresa.setPromocionesTemporales(promosTemporalesViejas);
        empresa.setPromocionesFijas(promosFijasViejas);
    }


}
