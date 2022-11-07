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

        Set<Mesa> operarios = gestionDeMesas.getMesas();
        DefaultListModel<Mesa> lista = new DefaultListModel<>();
        operarios.forEach(lista::addElement);

        ControladorGestionMesas.vistaGestionMesas.setModel(lista);

        if( mostrar )
            vistaGestionMesas.mostrar();
        return controladorGestionMesas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando =  e.getActionCommand();
        if(comando.equals("Alta Mesa")) {
            ControladorAltaMesa con = ControladorAltaMesa.getControladorAltaMesa();
        }else
        if( comando.equals("Baja Mesa") ){
            Mesa mesa = (Mesa) vistaGestionMesas.getSeleccion();
            try {
                gestionDeMesas.bajaMesa(mesa.getNroMesa());
                vistaGestionMesas.success("Mesa " + mesa.getNroMesa() + "dada de baja");
            } catch (MesaNoExistenteException ignored) {}
        }
        else{
            Mesa mesa = (Mesa) vistaGestionMesas.getSeleccion();
            try {
                gestionDeMesas.bajaMesa(mesa.getNroMesa());
                ControladorAltaOperario controladorAltaOperario = ControladorAltaOperario.getControladorAltaOperario(true);
                vistaGestionMesas.success("Mesa " + mesa.getNroMesa() + "modificada");
            } catch (MesaNoExistenteException ignored) {}
        }
    }
}
