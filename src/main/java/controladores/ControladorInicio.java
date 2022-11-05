package controladores;

import modelo.Empresa;
import vistas.IGenerica;
import vistas.VistaInicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInicio implements ActionListener {

    private IGenerica vistaInicio;
    private Empresa empresa;

    private static ControladorInicio controladorInicio = null;

    private ControladorInicio() {
        this.vistaInicio = new VistaInicio();
        this.empresa = Empresa.getEmpresa();
        this.vistaInicio.setActionListener(this);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public static ControladorInicio getControladorInicio(boolean mostrar) {
        if (controladorInicio == null) {
            controladorInicio = new ControladorInicio();
        }
        if( mostrar )
            controladorInicio.vistaInicio.mostrar();
        return controladorInicio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if(comando=="Gestionar Mozos")
            //Llama controlador gestion mozos
        else
            if(comando=="Gestionar Operarios")
                //llma cont gestion operaris
            else
                if(comando=="Gestionar Mesas")
                    //llama controlador
                else
                    if(comando=="Gestionar Productos")
                        //llama
                    else
                        if(comando=="Gestionar Promociones")
                            //llama
                        else
                            if(comando=="Abrir Local")
                                //llama
                             else
                                 ControladorLogin controladorLogin = ControladorLogin.getControladorLogin(true);

    }
}
