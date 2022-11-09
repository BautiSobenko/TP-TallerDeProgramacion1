package dto;

import enums.Dias;

import java.util.List;

public class PromocionDTO {

    private String nombre;
    private String id;
    private boolean activo;
    private List<Dias> diasPromo;

    public PromocionDTO(String nombre, String id, boolean activo, List<Dias> diasPromo) {
        this.nombre = nombre;
        this.id = id;
        this.activo = activo;
        this.diasPromo = diasPromo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public boolean isActivo() {
        return activo;
    }

    public List<Dias> getDiasPromo() {
        return diasPromo;
    }
}
