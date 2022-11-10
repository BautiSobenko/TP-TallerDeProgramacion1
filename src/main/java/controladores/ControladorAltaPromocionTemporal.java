package controladores;

import dto.PromocionTemporalDTO;
import enums.Dias;
import excepciones.PromocionExistenteException;
import modelo.promociones.PromocionTemporal;
import negocio.GestionDePromociones;
import vistas.VistaAltaPromocionTemporal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorAltaPromocionTemporal implements ActionListener {

    private GestionDePromociones gestionDePromociones;
    private static ControladorAltaPromocionTemporal controladorAltaPromocionTemporal = null;
    private VistaAltaPromocionTemporal vistaAltaPromocionTemporal;

    public ControladorAltaPromocionTemporal(){
        vistaAltaPromocionTemporal = new VistaAltaPromocionTemporal();
        vistaAltaPromocionTemporal.setActionListener(this);
        this.gestionDePromociones = GestionDePromociones.get();
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

        if(comando.equalsIgnoreCase("Aceptar")){
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
            if(porcentajeDesc==0)
                ControladorAltaPromocionTemporal.getControladorAltaPromocionTemporal();
            else {
                boolean isAcumulable = vistaAltaPromocionTemporal.getChckbxPromoAcumulable().isSelected();
                boolean activa = vistaAltaPromocionTemporal.getChckbxPromoActiva().isSelected();
                String nombre = vistaAltaPromocionTemporal.getNombre();
                PromocionTemporalDTO promo = new PromocionTemporalDTO(nombre, activa, dias, formaDePago, porcentajeDesc, isAcumulable);
                try {
                    gestionDePromociones.altaPromocion(promo);
                    this.vistaAltaPromocionTemporal.success("La promocion " + promo.getNombre() + " se ha dado de alta con exito");
                    vistaAltaPromocionTemporal.esconder();
                    ControladorGestionPromociones.getControladorGestionPromociones(true);
                } catch (PromocionExistenteException ex) {
                    this.vistaAltaPromocionTemporal.failure("La promocion " + promo.getNombre() + " ya se encuentra en el sistema");
                    vistaAltaPromocionTemporal.limpia();
                }
            }
        }
        else if( comando.equals("Volver")) {
            vistaAltaPromocionTemporal.esconder();
            ControladorGestionPromociones con = ControladorGestionPromociones.getControladorGestionPromociones(true);
        }
    }
}
