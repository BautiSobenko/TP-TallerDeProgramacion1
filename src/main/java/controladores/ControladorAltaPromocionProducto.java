package controladores;

import dto.PromocionProductoDTO;
import enums.Dias;
import excepciones.PromocionExistenteException;
import modelo.Producto;
import negocio.GestionDePromociones;
import vistas.VistaAltaPromocionProducto;
import vistas.VistaAltaPromocionTemporal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorAltaPromocionProducto implements ActionListener {

    private GestionDePromociones gestionDePromociones;
    private static ControladorAltaPromocionProducto controladorAltaPromocionProducto = null;
    private static VistaAltaPromocionProducto vistaAltaPromocionProducto;

    private void ControladorAltaPromocionProducto(){
        this.gestionDePromociones = GestionDePromociones.get();
        vistaAltaPromocionProducto = new VistaAltaPromocionProducto();
        vistaAltaPromocionProducto.setActionListener(this);
    }

    public static ControladorAltaPromocionProducto getControladorAltaPromocionProducto() {
        if (controladorAltaPromocionProducto == null) {
            controladorAltaPromocionProducto = new ControladorAltaPromocionProducto();
        }
        vistaAltaPromocionProducto.mostrar();

        return controladorAltaPromocionProducto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if(comando.equalsIgnoreCase("Finalizar")){
            float precioPromo;
            int cantMinima;
            String nombre = vistaAltaPromocionProducto.getNombre();
            boolean activa = vistaAltaPromocionProducto.getChckbxActiva().isSelected();
            List<Dias> dias = new ArrayList<>();
            if(vistaAltaPromocionProducto.getChckbxLunes().isSelected())
                dias.add(Dias.LUNES);
            if(vistaAltaPromocionProducto.getChckbxMartes().isSelected())
                dias.add(Dias.MARTES);
            if(vistaAltaPromocionProducto.getChckbxMiercoles().isSelected())
                dias.add(Dias.MIERCOLES);
            if(vistaAltaPromocionProducto.getChckbxJueves().isSelected())
                dias.add(Dias.JUEVES);
            if(vistaAltaPromocionProducto.getChckbxViernes().isSelected())
                dias.add(Dias.VIERNES);
            if(vistaAltaPromocionProducto.getChckbxSabado().isSelected())
                dias.add(Dias.SABADO);
            if(vistaAltaPromocionProducto.getChckbxDomingo().isSelected())
                dias.add(Dias.DOMINGO);
            Producto prod = (Producto) vistaAltaPromocionProducto.getComboBox().getSelectedItem();
            PromocionProductoDTO prom = null;
            if(vistaAltaPromocionProducto.getChckbxDesc().isSelected()) {
                precioPromo = vistaAltaPromocionProducto.getPrecioPromo();
                cantMinima = vistaAltaPromocionProducto.getCantMinima();
                prom = new PromocionProductoDTO(nombre, activa, dias, prod, false, true, cantMinima, precioPromo);
            }
            else{
                prom = new PromocionProductoDTO(nombre, activa, dias, prod, true, false,0, 0);
            }
            try {
                gestionDePromociones.altaPromocion(prom);
                this.vistaAltaPromocionProducto.success("La promocion fija: " + prom.getNombre() + " se ha dado de alta con exito");
            } catch (PromocionExistenteException ex) {
                this.vistaAltaPromocionProducto.failure("La promocion fija:" + prom.getNombre() + " ya se encuentra en el sistema");
            }
        }
        else if( comando.equals("Volver") ){
            vistaAltaPromocionProducto.esconder();
            ControladorGestionPromociones con = ControladorGestionPromociones.getControladorGestionPromociones(true);
        }
    }
}
