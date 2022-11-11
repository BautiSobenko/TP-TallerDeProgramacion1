package modelo;

import enums.EstadoComanda;

import javax.xml.validation.TypeInfoProvider;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Comanda {

    private Instant fecha;
    private Mesa mesa;
    private List<Pedido> pedidos;
    private EstadoComanda estado;

    public Comanda(Mesa mesa) {
        this.mesa = mesa;
        this.pedidos = new ArrayList<>();
        this.estado = EstadoComanda.ABIERTA;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
