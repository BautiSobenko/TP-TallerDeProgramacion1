package dto;

public class MesaDTO {

    /*
    No tendra sentido persistir el Estado de la mesa
    o bien el Mozo asignado
     */
    private int nroMesa;
    private int cantSillas;

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
}
