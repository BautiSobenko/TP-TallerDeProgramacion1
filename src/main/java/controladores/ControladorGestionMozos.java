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

        Set<Mozo> mozos = gestionDeMozos.getMozos();
        DefaultListModel<Mozo> listaMozos = new DefaultListModel<>();
        mozos.forEach(listaMozos::addElement);

        ControladorGestionMozos.vistaGestionMozos.setModel(listaMozos);

        vistaGestionMozos.mostrar();

        return controladorGestionMozos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando =  e.getActionCommand();
        if(comando.equals("Alta Mozo")) {
           ControladorAltaMozo ctrl = ControladorAltaMozo.getControladorAltaMozo("Alta");
        }
        else{
            Mozo mozo = (Mozo) vistaGestionMozos.getSeleccion();
            if( comando.equals("Baja Mozo") ){
            try {
                gestionDeMozos.bajaMozo(mozo);
                Set<Mozo> mozos = gestionDeMozos.getMozos();
                DefaultListModel<Mozo> updatedList = new DefaultListModel<>();
                mozos.forEach(updatedList::addElement);
                vistaGestionMozos.setModel(updatedList);
                vistaGestionMozos.success("El Mozo: " + mozo.getNombreCompleto() + " fue dado de baja con exito");
            } catch (PermisoDenegadoException exc) {

            }
        }
        else if( comando.equals("Modificar Mozo") ){
            ControladorAltaMozo ctrl = ControladorAltaMozo.getControladorAltaMozo("Modificar", mozo);
        }
        else if( comando.equals("Volver") ) {
            ControladorInicio controladorInicio = ControladorInicio.getControladorInicio(true);
            vistaGestionMozos.esconder();
        }
        else {
                if (comando.equalsIgnoreCase("Calculo sueldo")) {
                    double sueldo = gestionDeMozos.calculaSueldo(mozo);
                    vistaGestionMozos.success("El mozo "+ mozo.getNombreCompleto()+" tiene un sueldo de $"+sueldo);
                } else {
                    ControladorCambioEstadoMozo.getControladorCambioEstadoMozo(mozo);
                    vistaGestionMozos.esconder();
                }
            }
        }

    }
}
