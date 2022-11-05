package controladores;

import dto.MesaDTO;
import excepciones.MesaExistenteException;
import modelo.Operario;
import negocio.GestionDeMesas;
import vistas.VistaAltaMesa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAltaMesa implements ActionListener {

    private static ControladorAltaMesa controladorAltaMesa = null;
    private final GestionDeMesas gestionDeMesas;
    private final VistaAltaMesa vistaAltaMesa;
    private Operario logueado;

    private ControladorAltaMesa() {
        this.vistaAltaMesa = new VistaAltaMesa();
        this.vistaAltaMesa.setActionListener(this);
        this.gestionDeMesas = GestionDeMesas.get();
    }

    public static ControladorAltaMesa getControladorAltaMesa() {
        if (controladorAltaMesa == null) {
            controladorAltaMesa = new ControladorAltaMesa();
        }
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
                gestionDeMesas.altaMesa(mesaDTO);
                this.vistaAltaMesa.success();
            } catch (MesaExistenteException ex) {
                this.vistaAltaMesa.failure();
            }
            this.vistaAltaMesa.esconder();
        }else if( comando.equalsIgnoreCase("Volver") ){
            this.vistaAltaMesa.esconder();
            ControladorGestionMesas CMesas = ControladorGestionMesas.get(true);
        }
    }

}
