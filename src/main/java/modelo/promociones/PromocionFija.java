package modelo.promociones;

import enums.Dias;
import modelo.Producto;

import java.util.List;

public class PromocionFija extends Promocion{

    Producto producto;
    boolean dosPorUno;
    boolean dtoPorCant;
    int dtoPorCantMin;
    double dtoPorCantPrecioU;

    public PromocionFija(String nombre, List<Dias> diasPromo, Producto producto, boolean dosPorUno, boolean dtoPorCant, int dtoPorCantMin, double dtoPorCantPrecioU) {
        super(nombre, diasPromo);
        this.producto = producto;
        this.dosPorUno = dosPorUno;
        this.dtoPorCant = dtoPorCant;
        this.dtoPorCantMin = dtoPorCantMin;
        this.dtoPorCantPrecioU = dtoPorCantPrecioU;
    }
}
