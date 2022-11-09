package dto;

import enums.Dias;
import modelo.Producto;

import java.util.List;

public class PromocionProductoDTO {
    Producto producto;
    boolean dosPorUno;
    boolean dtoPorCant;
    int dtoPorCantMin;
    double dtoPorCantPrecioU;
    String nombre;
    List<Dias> dias;

    public PromocionProductoDTO(Producto producto, boolean dosPorUno, boolean dtoPorCant, int dtoPorCantMin, double dtoPorCantPrecioU, String nombre, List<Dias> dias) {
        this.producto = producto;
        this.dosPorUno = dosPorUno;
        this.dtoPorCant = dtoPorCant;
        this.dtoPorCantMin = dtoPorCantMin;
        this.dtoPorCantPrecioU = dtoPorCantPrecioU;
        this.nombre = nombre;
        this.dias = dias;
    }
}
