package controladores;

import excepciones.MesaNoExistenteException;
import excepciones.MozoNoExistenteException;
import excepciones.PermisoDenegadoException;
import modelo.Mesa;
import modelo.Mozo;
import negocio.GestionDeMesas;
import negocio.GestionDeMozos;
import vistas.IVistaGestion;
import vistas.VistaGestionMesas;
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

        Set<Mozo> operarios = gestionDeMozos.getMozos();
        DefaultListModel<Mozo> lista = new DefaultListModel<>();
        operarios.forEach(lista::addElement);

        ControladorGestionMozos.vistaGestionMozos.setModel(lista);

        if( mostrar )
            vistaGestionMozos.mostrar();
        return controladorGestionMozos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando =  e.getActionCommand();
        if(comando.equals("Alta Mozo")) {
           // ControladorAltaMozo con = ControladorAltaMesa.getControladorAltaMesa();
        }else
        if( comando.equals("Baja Mozo") ){
            Mozo mozo = (Mozo) vistaGestionMozos.getSeleccion();
            try {
                gestionDeMozos.bajaMozo(mozo);
                vistaGestionMozos.success("Mozo " + mozo.getNombreCompleto() + "dado de baja");
            } catch (MozoNoExistenteException | PermisoDenegadoException ignored) {}
        }
        else{
            Mozo mozo = (Mozo) vistaGestionMozos.getSeleccion();
            try {
                gestionDeMozos.bajaMozo(mozo);
                //Llamada a alta
                vistaGestionMozos.success("Mozo " + mozo.getNombreCompleto() + " ha sido modificado");
            } catch (MozoNoExistenteException | PermisoDenegadoException ignored) {}
        }
    }
}
