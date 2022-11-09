package controladores;

import dto.PromocionProductoDTO;
import enums.Dias;
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
    private static ControladorAltaPromocionProducto controladorAltaPromocionProducto=null;
    private VistaAltaPromocionProducto vistaAltaPromocionProducto;

    public void ControladorAltaPromocionProducto(){
        this.gestionDePromociones = GestionDePromociones.get();
        vistaAltaPromocionProducto = new VistaAltaPromocionProducto();
    }

    public static ControladorAltaPromocionProducto getControladorAltaPromocionProducto() {
        if (controladorAltaPromocionProducto == null) {
            controladorAltaPromocionProducto = new ControladorAltaPromocionProducto();
        }
        controladorAltaPromocionProducto.vistaAltaPromocionProducto.mostrar();
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
            if(vistaAltaPromocionProducto.getChckbxDesc().isSelected()) {
                precioPromo = vistaAltaPromocionProducto.getPrecioPromo();
                cantMinima = vistaAltaPromocionProducto.getCantMinima();
                PromocionProductoDTO prom = new PromocionProductoDTO(nombre, activa, dias, prod, false, true, cantMinima, precioPromo);
            }
            else{
                PromocionProductoDTO prom = new PromocionProductoDTO(nombre, activa, dias, prod, true, false,0, 0);
            }
            //Llama a gestion de promociones para agregarla
        }
        else{
            vistaAltaPromocionProducto.esconder();
            ControladorGestionPromociones con = ControladorGestionPromociones.getControladorGestionPromociones(true);
        }
    }
}
