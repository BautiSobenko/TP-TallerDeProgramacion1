package controladores;

import excepciones.OperarioExistenteException;
import excepciones.PermisoDenegadoException;
import modelo.Empresa;
import modelo.Operario;
import negocio.GestionDeOperarios;
import vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAltaOperario implements ActionListener {

    private static ControladorAltaOperario controladorAltaOperario = null;
    private Empresa empresa;
    private IAltaOperario vistaAltaOperario;
    private GestionDeOperarios op;

    private ControladorAltaOperario() {
        this.vistaAltaOperario = new VistaAltaOperario();
        this.op = GestionDeOperarios.get();
        this.vistaAltaOperario.setActionListener(this);
    }

    public static ControladorAltaOperario getControladorAltaOperario(boolean mostrar) {
        if (controladorAltaOperario == null) {
            controladorAltaOperario = new ControladorAltaOperario();
        }
        if( mostrar )
            controladorAltaOperario.vistaAltaOperario.mostrar();
        return controladorAltaOperario;
    }

    public IGenerica getVistaAltaOperario() {
        return vistaAltaOperario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if(comando.equalsIgnoreCase("Aceptar")){
            String nombre = this.vistaAltaOperario.getNombre();
            String username = this.vistaAltaOperario.getUsername();
            String password = this.vistaAltaOperario.getPassword();
            try {
                this.op.altaOperario(new Operario(nombre,username,password));
            } catch (OperarioExistenteException ex) {
                throw new RuntimeException(ex);
            } catch (PermisoDenegadoException ex) {
                throw new RuntimeException(ex);
            }
            this.vistaAltaOperario.esconder();
        }
        else{
            this.vistaAltaOperario.esconder();
            ControladorGestionOperario con = ControladorGestionOperario.getControladorGestionOperario(true);

        }
    }
}
