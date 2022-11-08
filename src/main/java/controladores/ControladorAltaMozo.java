package controladores;


import dto.MozoDTO;
import excepciones.MozoExistenteException;
import excepciones.PermisoDenegadoException;
import negocio.GestionDeMozos;
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
            int hijos = Integer.parseInt(this.vistaAltaMozo.getCantHijos());
            String fecha = this.vistaAltaMozo.getFechaNacimiento();
            MozoDTO mozoDTO = new MozoDTO(nombre,fecha,hijos);
            try {
                gestionDeMozos.altaMozo(mozoDTO);
                this.vistaAltaMozo.success("El mozo se dio de alta con exito");
            } catch (MozoExistenteException | PermisoDenegadoException ex) {
                this.vistaAltaMozo.failure("El mozo ya se encuentra en el sistema");
            }
            this.vistaAltaMozo.esconder();
        }else if( comando.equalsIgnoreCase("Volver") ){
            this.vistaAltaMozo.esconder();
        }
        ControladorGestionMozos CMosos = ControladorGestionMozos.getControladorGestionMozos(true);
    }
}
