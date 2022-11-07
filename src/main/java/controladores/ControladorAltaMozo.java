package controladores;

import dto.MesaDTO;
import dto.MozoDTO;
import excepciones.MesaExistenteException;
import modelo.Operario;
import negocio.GestionDeMesas;
import negocio.GestionDeMozos;
import vistas.VistaAltaMesa;
import vistas.VistaAltaMozo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAltaMozo implements ActionListener {
    private static ControladorAltaMozo controladorAltaMozo = null;
    private final GestionDeMozos gestionDeMozos;
    private final VistaAltaMozo vistaAltaMozo;

    private ControladorAltaMozo() {
        this.vistaAltaMozo = new VistaAltaMozo();
        this.vistaAltaMozo.setActionListener(this);
        this.gestionDeMozos = GestionDeMozos.get();
    }

    public static ControladorAltaMozo getControladorAltaMozo() {
        if (controladorAltaMozo == null) {
            controladorAltaMozo = new ControladorAltaMozo();
        }
        controladorAltaMozo.vistaAltaMozo.mostrar();
        return controladorAltaMozo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if( comando.equalsIgnoreCase("Aceptar") ){
            String nombre = this.vistaAltaMozo.getNombre();
            int hijos = this.vistaAltaMozo.getCantHijos();
            String fecha = this.vistaAltaMozo.getFechaNacimiento();
            MozoDTO mozoDTO = new MozoDTO(nombre,fecha,hijos);
            try {
                gestionDeMozos.altaMozo(mozoDTO);
                this.vistaAltaMozo.success("La mesa se dio de alta con exito");
            } catch (MesaExistenteException ex) {
                this.vistaAltaMozo.failure("La mesa ya se encuentra en el sistema");
            }
            this.vistaAltaMozo.esconder();
        }else if( comando.equalsIgnoreCase("Volver") ){
            this.vistaAltaMozo.esconder();
        }
        ControladorGestionMozos CMosos = ControladorGestionMozos.getControladorGestionMozos(true);
    }
}