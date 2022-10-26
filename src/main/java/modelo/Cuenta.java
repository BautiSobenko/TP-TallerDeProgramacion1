package modelo;

import enums.EstadoComanda;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    private List<Pedido> pedidos;
    private EstadoComanda estadoPedido;
    private Instant apertura;
    private Instant cierre;

    public Cuenta() {
        pedidos = new ArrayList<>();
        estadoPedido = EstadoComanda.ABIERTA;
        apertura = Instant.now();
        cierre = null;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public EstadoComanda getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoComanda estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Instant getApertura() {
        return apertura;
    }

    public Instant getCierre() {
        return cierre;
    }

    public void setCierre(Instant cierre) {
        this.cierre = cierre;
    }
}
