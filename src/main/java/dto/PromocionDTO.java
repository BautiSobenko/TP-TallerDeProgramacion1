package dto;

import enums.Dias;

import java.util.List;

public class PromocionDTO {

    protected String nombre;
    protected boolean activo;
    protected List<Dias> diasPromo;

    public PromocionDTO(String nombre,boolean activo, List<Dias> diasPromo) {
        this.nombre = nombre;
        this.activo = activo;
        this.diasPromo = diasPromo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public List<Dias> getDiasPromo() {
        return diasPromo;
    }
}
