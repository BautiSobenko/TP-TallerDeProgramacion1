package controladores;

import excepciones.MozoNoExistenteException;
import excepciones.PermisoDenegadoException;
import modelo.Mozo;
import negocio.GestionDeMozos;
import vistas.IVistaGestion;
import vistas.VistaGestionMozos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ControladorGestionMozos implements ActionListener {

    private static IVistaGestion vistaGestionMozos;
    private static GestionDeMozos gestionDeMozos;

    private static ControladorGestionMozos controladorGestionMozos = null;


    private ControladorGestionMozos() {
        vistaGestionMozos = new VistaGestionMozos();
        vistaGestionMozos.setActionListener(this);
        gestionDeMozos = GestionDeMozos.get();
    }

    public static ControladorGestionMozos getControladorGestionMozos() {
        if (controladorGestionMozos == null)
            controladorGestionMozos = new ControladorGestionMozos();

        controladorGestionMozos.actualizaListaMozos();

        vistaGestionMozos.mostrar();

        return controladorGestionMozos;
    }

    public void actualizaListaMozos(){
        Set<Mozo> mozos = gestionDeMozos.getMozos();
        DefaultListModel<Mozo> listaMozos = new DefaultListModel<>();
        mozos.forEach(listaMozos::addElement);
        ControladorGestionMozos.vistaGestionMozos.setModel(listaMozos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando =  e.getActionCommand();
        if(comando.equals("Alta Mozo")) {
            vistaGestionMozos.esconder();
           ControladorAltaMozo ctrl = ControladorAltaMozo.getControladorAltaMozo("Alta");
        }
        else if( comando.equals("Baja Mozo") ){
            Mozo mozo = (Mozo) vistaGestionMozos.getSeleccion();
            gestionDeMozos.bajaMozo(mozo);
            vistaGestionMozos.success("El Mozo: " + mozo.getNombreCompleto() + " fue dado de baja con exito");

            this.actualizaListaMozos();
        }
        else if( comando.equals("Modificar Mozo") ){
            vistaGestionMozos.esconder();
            Mozo mozo = (Mozo) vistaGestionMozos.getSeleccion();
            ControladorAltaMozo ctrl = ControladorAltaMozo.getControladorAltaMozo("Modificar", mozo);
        }
        else if( comando.equals("Volver") ) {
            ControladorInicio controladorInicio = ControladorInicio.getControladorInicio(true);
            vistaGestionMozos.esconder();
        }
        else{
            Mozo mozo = (Mozo) vistaGestionMozos.getSeleccion();
            vistaGestionMozos.esconder();
            ControladorCambioEstadoMozo.getControladorCambioEstadoMozo(mozo);
        }

    }
}
