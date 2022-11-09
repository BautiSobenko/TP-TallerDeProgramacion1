package dto;

import enums.Dias;

import java.util.List;

public class PromocionTemporalDTO {
    private String nombre;
    private List<Dias> dias;
    private String formaDePago;
    private float porcentajeDescuento;
    private boolean esAcumulable;

    public PromocionTemporalDTO(String nombre, List<Dias> dias, String formaDePago, float porcentajeDescuento, boolean esAcumulable) {
        this.nombre = nombre;
        this.dias = dias;
        this.formaDePago = formaDePago;
        this.porcentajeDescuento = porcentajeDescuento;
        this.esAcumulable = esAcumulable;
    }
}
