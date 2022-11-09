package modelo.promociones;

import enums.Dias;

import java.util.ArrayList;
import java.util.List;

public class Promocion {

    private String nombre;

    private static int idSiguiente=0;
    private int idPromocion;
    private boolean activo;
    private List<Dias> diasPromo;

    public Promocion(String nombre, List<Dias> diasPromo) {
        this.nombre = nombre;
        this.diasPromo = diasPromo;
        this.activo = true;
        this.idPromocion = ++idSiguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Dias> getDiasPromo() {
        return diasPromo;
    }

    public void addDiaPromo(Dias diaPromo) {
        this.diasPromo.add(diaPromo);
    }

    public void removeDiaPromo(Dias diaPromo) {
        if(this.diasPromo.contains(diaPromo))
            this.diasPromo.remove(diaPromo);
    }
}
