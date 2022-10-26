package modelo.promociones;

import enums.Dias;

import java.util.List;

public class PromocionTemporal extends Promocion{

    private String formaPago;
    private int porcentajeDescuento;
    private boolean esAcumulable;

    public PromocionTemporal(String nombre, List<Dias> diasPromo, String formaPago, int porcentajeDescuento, boolean esAcumulable) {
        super(nombre, diasPromo);
        this.formaPago = formaPago;
        this.porcentajeDescuento = porcentajeDescuento;
        this.esAcumulable = esAcumulable;
    }
}
