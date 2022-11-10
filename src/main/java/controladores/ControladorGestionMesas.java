package controladores;

import excepciones.MesaNoExistenteException;
import excepciones.OperarioNoExistenteException;
import excepciones.PermisoDenegadoException;
import modelo.Empresa;
import modelo.Mesa;
import modelo.Operario;
import negocio.GestionDeMesas;

import vistas.IVistaGestion;
import vistas.VistaGestionMesas;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ControladorGestionMesas implements ActionListener {

    private static IVistaGestion vistaGestionMesas;
    private static GestionDeMesas gestionDeMesas;

    private static ControladorGestionMesas controladorGestionMesas = null;


    private ControladorGestionMesas() {
        vistaGestionMesas = new VistaGestionMesas();
        vistaGestionMesas.setActionListener(this);
        gestionDeMesas = GestionDeMesas.get();
    }

    public static ControladorGestionMesas getControladorGestionMesas(boolean mostrar) {
        if (controladorGestionMesas == null)
            controladorGestionMesas = new ControladorGestionMesas();

        Set<Mesa> mesas = gestionDeMesas.getMesas();
        DefaultListModel<Mesa> listaMesas = new DefaultListModel<>();
        mesas.forEach(listaMesas::addElement);

        ControladorGestionMesas.vistaGestionMesas.setModel(listaMesas);

        if( mostrar )
            vistaGestionMesas.mostrar();
        return controladorGestionMesas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando =  e.getActionCommand();
        if(comando.equals("Alta Mesa")) {
            vistaGestionMesas.esconder();
            ControladorAltaMesa con = ControladorAltaMesa.getControladorAltaMesa();
        }else
            if( comando.equals("Baja Mesa") ){
            Mesa mesa = (Mesa) vistaGestionMesas.getSeleccion();
            gestionDeMesas.bajaMesa(mesa.getNroMesa());
            Set<Mesa> mesas = gestionDeMesas.getMesas();
            DefaultListModel<Mesa> updatedList = new DefaultListModel<>();
            mesas.forEach(updatedList::addElement);
            vistaGestionMesas.setModel(updatedList);
            vistaGestionMesas.success("Mesa " + mesa.getNroMesa() + "dada de baja");
        } else
            if( comando.equals("Modificar Mesa") ){
            Mesa mesa = (Mesa) vistaGestionMesas.getSeleccion();
            gestionDeMesas.bajaMesa(mesa.getNroMesa());
            ControladorAltaMesa con = ControladorAltaMesa.getControladorAltaMesa();
            Set<Mesa> mesas = gestionDeMesas.getMesas();
            DefaultListModel<Mesa> updatedList = new DefaultListModel<>();
            mesas.forEach(updatedList::addElement);
            vistaGestionMesas.setModel(updatedList);
            vistaGestionMesas.success("Mesa " + mesa.getNroMesa() + "modificada");
        } else{
                vistaGestionMesas.esconder();
                //!ControladorAsignarMozo ctrl = ControladorAsignarMozo.getControladorAsignarMozo();
        }
    }
}
