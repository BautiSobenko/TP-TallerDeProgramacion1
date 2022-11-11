package dto;

import modelo.Mozo;

public class MesaDTO {

    /*
    No tendra sentido persistir el Estado de la mesa
    o bien el Mozo asignado
     */
    private int nroMesa;
    private int cantSillas;
    private Mozo mozoAsignado;

    public MesaDTO(int nroMesa, int cantSillas) {
        this.nroMesa = nroMesa;
        this.cantSillas = cantSillas;
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

    public Mozo getMozoAsignado() {
        return mozoAsignado;
    }

    public void setMozoAsignado(Mozo mozoAsignado) {
        this.mozoAsignado = mozoAsignado;
    }
}
