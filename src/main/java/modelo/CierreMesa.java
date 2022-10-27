package modelo;

import modelo.promociones.Promocion;

import java.util.ArrayList;
import java.util.List;

public class CierreMesa extends Cuenta{

    private Mesa mesa;
    private List<Promocion> promociones;
    private Float total;


    public CierreMesa(Mesa mesa) {
        super();
        this.mesa = mesa;
        this.promociones = new ArrayList<>();
        total = 0F;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }


}
