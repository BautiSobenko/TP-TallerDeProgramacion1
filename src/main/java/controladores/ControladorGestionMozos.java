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

    public static ControladorGestionMozos getControladorGestionMozos(boolean mostrar) {
        if (controladorGestionMozos == null)
            controladorGestionMozos = new ControladorGestionMozos();

        Set<Mozo> mozos = gestionDeMozos.getMozos();
        DefaultListModel<Mozo> listaMozos = new DefaultListModel<>();
        mozos.forEach(listaMozos::addElement);

        ControladorGestionMozos.vistaGestionMozos.setModel(listaMozos);

        if( mostrar )
            vistaGestionMozos.mostrar();

        return controladorGestionMozos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando =  e.getActionCommand();
        if(comando.equals("Alta Mozo")) {
           ControladorAltaMozo ctrl = ControladorAltaMozo.getControladorAltaMozo();
        }
        else if( comando.equals("Baja Mozo") ){
            Mozo mozo = (Mozo) vistaGestionMozos.getSeleccion();
            try {
                gestionDeMozos.bajaMozo(mozo);
                Set<Mozo> mozos = gestionDeMozos.getMozos();
                DefaultListModel<Mozo> updatedList = new DefaultListModel<>();
                mozos.forEach(updatedList::addElement);
                vistaGestionMozos.setModel(updatedList);
                vistaGestionMozos.success("Mozo " + mozo.getNombreCompleto() + " dado de baja");
            } catch (MozoNoExistenteException | PermisoDenegadoException exc) {

            }
        }
        else if( comando.equals("Modificar Mozo") ){
            Mozo mozo = (Mozo) vistaGestionMozos.getSeleccion();
            try {
                gestionDeMozos.bajaMozo(mozo);
                ControladorAltaMozo ctrl = ControladorAltaMozo.getControladorAltaMozo();
                Set<Mozo> mozos = gestionDeMozos.getMozos();
                DefaultListModel<Mozo> updatedList = new DefaultListModel<>();
                mozos.forEach(updatedList::addElement);
                vistaGestionMozos.setModel(updatedList);
                vistaGestionMozos.success("Mozo " + mozo.getNombreCompleto() + " ha sido modificado");
            } catch (MozoNoExistenteException | PermisoDenegadoException ignored) {}
        }
        else if( comando.equals("Asignar Mozos") ) {
            //!Realizar vista Asignar mozo
            //!Realizar controlador Asignar mozo
        }
        else if( comando.equals("Volver") ) {
            ControladorInicio controladorInicio = ControladorInicio.getControladorInicio(true);
            vistaGestionMozos.esconder();
        }

    }
}
