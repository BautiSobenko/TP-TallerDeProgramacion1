package dto;

import enums.Dias;
import modelo.Producto;

import java.util.List;

public class PromocionProductoDTO extends PromocionDTO{

    Producto producto;
    boolean dosPorUno;
    boolean dtoPorCant;
    int dtoPorCantMin;
    double dtoPorCantPrecioU;

    public PromocionProductoDTO(String nombre, String id, boolean activo, List<Dias> diasPromo, Producto producto, boolean dosPorUno, boolean dtoPorCant, int dtoPorCantMin, double dtoPorCantPrecioU) {
        super(nombre, id, activo, diasPromo);
        this.producto = producto;
        this.dosPorUno = dosPorUno;
        this.dtoPorCant = dtoPorCant;
        this.dtoPorCantMin = dtoPorCantMin;
        this.dtoPorCantPrecioU = dtoPorCantPrecioU;
    }

    public Producto getProducto() {
        return producto;
    }

    public boolean isDosPorUno() {
        return dosPorUno;
    }

    public boolean isDtoPorCant() {
        return dtoPorCant;
    }

    public int getDtoPorCantMin() {
        return dtoPorCantMin;
    }

    public double getDtoPorCantPrecioU() {
        return dtoPorCantPrecioU;
    }
}
