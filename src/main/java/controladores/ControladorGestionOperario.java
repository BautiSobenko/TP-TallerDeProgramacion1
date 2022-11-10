package controladores;

import excepciones.OperarioNoExistenteException;
import excepciones.PermisoDenegadoException;
import modelo.Empresa;
import modelo.Operario;
import negocio.GestionDeOperarios;
import vistas.IVistaGestion;
import vistas.VistaGestionOperarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ControladorGestionOperario implements ActionListener {

    private static IVistaGestion vistaGestionOperarios;
    private Empresa empresa;

    private static GestionDeOperarios gestionOp;

    private static ControladorGestionOperario controladorGestionOperario = null;


    private ControladorGestionOperario() {
        vistaGestionOperarios = new VistaGestionOperarios();
        this.empresa = Empresa.getEmpresa();
        vistaGestionOperarios.setActionListener(this);
        gestionOp = GestionDeOperarios.get();
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public static ControladorGestionOperario getControladorGestionOperario(boolean mostrar) {
        if (controladorGestionOperario == null)
            controladorGestionOperario = new ControladorGestionOperario();

        Set<Operario> operarios = gestionOp.getOperarios();
        DefaultListModel<Operario> lista = new DefaultListModel<>();
        operarios.forEach(lista::addElement);

        ControladorGestionOperario.vistaGestionOperarios.setModel(lista);

        if( mostrar )
            vistaGestionOperarios.mostrar();
        return controladorGestionOperario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando =  e.getActionCommand();
        if(comando.equals("Alta Operario")) {
            vistaGestionOperarios.esconder();
            ControladorAltaOperario con = ControladorAltaOperario.getControladorAltaOperario("Alta");
        }
        else if( comando.equals("Baja Operario") ){
                Operario op = (Operario) vistaGestionOperarios.getSeleccion();
                try {
                    gestionOp.bajaOperario(op.getUsername());
                    Set<Operario> operarios = gestionOp.getOperarios();
                    DefaultListModel<Operario> updatedList = new DefaultListModel<>();
                    operarios.forEach(updatedList::addElement);
                    vistaGestionOperarios.setModel(updatedList);
                    vistaGestionOperarios.success("Operario " + op.getUsername() + "dado de baja");
                } catch (PermisoDenegadoException ignored) {}
            }
        else if( comando.equals("Modificar Operario")){
                Operario op = (Operario) vistaGestionOperarios.getSeleccion();
                    vistaGestionOperarios.esconder();
                    ControladorAltaOperario controladorAltaOperario = ControladorAltaOperario.getControladorAltaOperario("Modificar", op);
            }
        else if( comando.equals("Volver") ){
            ControladorInicio controladorInicio = ControladorInicio.getControladorInicio(true);
            vistaGestionOperarios.esconder();
        }
    }
}
