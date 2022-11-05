package controladores;

import excepciones.OperarioNoExistenteException;
import excepciones.PermisoDenegadoException;
import modelo.Empresa;
import modelo.Operario;
import negocio.GestionDeOperarios;
import vistas.IGenerica;
import vistas.IVistaGestion;
import vistas.VistaGestionOperarios;
import vistas.VistaInicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

public class ControladorGestionOperario implements ActionListener {

    private static IVistaGestion vistaGestionOperarios;
    private Empresa empresa;

    private static GestionDeOperarios gestionOp;

    private static ControladorGestionOperario controladorGestionOperario = null;


    private ControladorGestionOperario() {
        this.vistaGestionOperarios = new VistaGestionOperarios();
        this.empresa = Empresa.getEmpresa();
        this.vistaGestionOperarios.setActionListener(this);
        this.gestionOp = gestionOp.get();
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
            controladorGestionOperario.vistaGestionOperarios.mostrar();
        return controladorGestionOperario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando =  e.getActionCommand();
        if(comando=="Alta Operario")
            //llama
        else
            if(comando=="Baja Operario"){
                Operario op = (Operario) this.vistaGestionOperarios.getSeleccion();
                try {
                    gestionOp.bajaOperario(op.getUsername());
                } catch (OperarioNoExistenteException | PermisoDenegadoException ignored) {}
            }
            else{
                Operario op = (Operario) this.vistaGestionOperarios.getSeleccion();
                try {
                    gestionOp.bajaOperario(op.getUsername());
                } catch (OperarioNoExistenteException | PermisoDenegadoException ignored) {}
                //Llama controlador alta
            }
    }
}
