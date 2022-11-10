package controladores;

import dto.MesaDTO;
import excepciones.MesaExistenteException;
import modelo.Mesa;
import modelo.Operario;
import negocio.GestionDeMesas;
import vistas.VistaAltaMesa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAltaMesa implements ActionListener {

    private static ControladorAltaMesa controladorAltaMesa = null;
    private final GestionDeMesas gestionDeMesas;
    private final VistaAltaMesa vistaAltaMesa;
    private String op;
    private Mesa mesa;

    private ControladorAltaMesa() {
        this.vistaAltaMesa = new VistaAltaMesa();
        this.vistaAltaMesa.setActionListener(this);
        this.gestionDeMesas = GestionDeMesas.get();
    }

    public static ControladorAltaMesa getControladorAltaMesa(String op) {
        if (controladorAltaMesa == null) {
            controladorAltaMesa = new ControladorAltaMesa();
        }
        controladorAltaMesa.op = op;
        controladorAltaMesa.vistaAltaMesa.mostrar();

        return controladorAltaMesa;
    }

    public static ControladorAltaMesa getControladorAltaMesa(String op, Mesa mesa) {
        if (controladorAltaMesa == null) {
            controladorAltaMesa = new ControladorAltaMesa();
        }
        controladorAltaMesa.op = op;
        controladorAltaMesa.mesa = mesa;
        controladorAltaMesa.vistaAltaMesa.mostrar();

        return controladorAltaMesa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if( comando.equalsIgnoreCase("Aceptar") ){
            int nroMesa = Integer.parseInt(this.vistaAltaMesa.getNumeroMesa());
            int cantSilla = Integer.parseInt(this.vistaAltaMesa.getCantSillas());
            MesaDTO mesaDTO = new MesaDTO(nroMesa, cantSilla);
            try {
                    if(op.equalsIgnoreCase("Alta")){
                        gestionDeMesas.altaMesa(mesaDTO);
                        this.vistaAltaMesa.success("La mesa: " + mesaDTO.getNroMesa() + " fue dada de alta con exito");
                    }else{
                        gestionDeMesas.bajaMesa(mesa.getNroMesa());
                        gestionDeMesas.altaMesa(mesaDTO);
                        this.vistaAltaMesa.success("La mesa: " + mesaDTO.getNroMesa() + " fue modificada con exito");
                    }
            } catch (MesaExistenteException ex) {
                    this.vistaAltaMesa.failure("La mesa: " + mesaDTO.getNroMesa() + " ya se encuentra en el sistema");
            }
        }else if( comando.equalsIgnoreCase("Volver") ){
            this.vistaAltaMesa.esconder();
        }
        ControladorGestionMesas CMesas = ControladorGestionMesas.getControladorGestionMesas(true);
    }

}
