package modelo;

import enums.EstadoMesa;

public class Mesa {
    private int nroMesa;
    private int cantSillas;
    private EstadoMesa estadoMesa;
    private Mozo mozoAsignado;
    private Cuenta comanda;

    public Mesa(int nroMesa, int cantSillas) {
        this.nroMesa = nroMesa;
        this.cantSillas = cantSillas;
        this.estadoMesa = EstadoMesa.LIBRE;
    }

    public int getNroMesa() {
        return nroMesa;
    }

    public void setNroMesa(int nroMesa) {
        this.nroMesa = nroMesa;
    }

    public int getCantSillas() {
        return cantSillas;
    }

    public void setCantSillas(int cantSillas) {
        this.cantSillas = cantSillas;
    }

    public EstadoMesa getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(EstadoMesa estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public Mozo getMozoAsignado() {
        return mozoAsignado;
    }

    public void setMozoAsignado(Mozo mozoAsignado) {
        this.mozoAsignado = mozoAsignado;
    }

    public Cuenta getComanda() {
        return comanda;
    }

    public void setComanda(Cuenta comanda) {
        this.comanda = comanda;
    }
}