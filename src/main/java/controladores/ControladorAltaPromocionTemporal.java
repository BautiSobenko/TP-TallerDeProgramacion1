package controladores;

import enums.Dias;
import negocio.GestionDePromociones;
import vistas.VistaAltaPromocionTemporal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorAltaPromocionTemporal implements ActionListener {

    private GestionDePromociones gestionDePromociones;
    private static ControladorAltaPromocionTemporal controladorAltaPromocionTemporal=null;
    private VistaAltaPromocionTemporal vistaAltaPromocionTemporal;

    public ControladorAltaPromocionTemporal(){
        this.gestionDePromociones = GestionDePromociones.get();
        vistaAltaPromocionTemporal = new VistaAltaPromocionTemporal();
    }

    public static ControladorAltaPromocionTemporal getControladorAltaPromocionTemporal() {
        if (controladorAltaPromocionTemporal == null) {
            controladorAltaPromocionTemporal = new ControladorAltaPromocionTemporal();
        }
        controladorAltaPromocionTemporal.vistaAltaPromocionTemporal.mostrar();
        return controladorAltaPromocionTemporal;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if(comando.equalsIgnoreCase("Finalizar")){
            List<Dias> dias = new ArrayList<>();
            if(vistaAltaPromocionTemporal.getChckbxLunes().isSelected())
                dias.add(Dias.LUNES);
            if(vistaAltaPromocionTemporal.getChckbxMartes().isSelected())
                dias.add(Dias.MARTES);
            if(vistaAltaPromocionTemporal.getChckbxMiercoles().isSelected())
                dias.add(Dias.MIERCOLES);
            if(vistaAltaPromocionTemporal.getChckbxJueves().isSelected())
                dias.add(Dias.JUEVES);
            if(vistaAltaPromocionTemporal.getChckbxViernes().isSelected())
                dias.add(Dias.VIERNES);
            if(vistaAltaPromocionTemporal.getChckbxSabado().isSelected())
                dias.add(Dias.SABADO);
            if(vistaAltaPromocionTemporal.getChckbxDomingo().isSelected())
                dias.add(Dias.DOMINGO);
            String formaDePago = vistaAltaPromocionTemporal.getSelection();
            float porcentajeDesc = vistaAltaPromocionTemporal.getPorcentajeDesc();
            boolean isAcumulable = vistaAltaPromocionTemporal.getChckbxPromoAcumulable().isSelected();
            String nombre = vistaAltaPromocionTemporal.getNombre();
            //Falta crear el dto y mandarlo a gestion de promociones
        }
        else{
            vistaAltaPromocionTemporal.esconder();
            ControladorGestionPromociones con = ControladorGestionPromociones.getControladorGestionPromociones(true);
        }
    }
}
