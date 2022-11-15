package escenarios;

import enums.Dias;
import modelo.*;
import modelo.promociones.PromocionFija;
import modelo.promociones.PromocionTemporal;

import java.util.ArrayList;
import java.util.List;

public class EscenarioPromocionesCargadas {

    Empresa empresa;
    Producto prod;
    PromocionFija promoFija;
    PromocionTemporal promocionTemporal;

    public EscenarioPromocionesCargadas( ) {
        this.empresa = Empresa.getEmpresa();
    }

    public void aplicarEscenarioPromocionesCargadas(){

        this.prod = new Producto("Morcilla",90,25,30);
        empresa.getProductos().add(prod);

        List<Dias> dias = new ArrayList<>();
        dias.add(Dias.LUNES);
        dias.add(Dias.MIERCOLES);
        promoFija = new PromocionFija("Promo Morci",dias,prod,true,false,0,0);

        empresa.getPromocionesFijas().add(promoFija);

        List<Dias> diasPromo = new ArrayList<>();
        diasPromo.add(Dias.SABADO);
        diasPromo.add(Dias.DOMINGO);
        promocionTemporal = new PromocionTemporal("Promo piola", diasPromo, "Efectivo", 20F, true);

        empresa.getPromocionesTemporales().add(promocionTemporal);


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
