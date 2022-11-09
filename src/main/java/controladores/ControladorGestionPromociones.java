package controladores;

import excepciones.ProductoNoExistenteException;
import excepciones.PromocionNoExistenteException;
import modelo.Producto;
import modelo.promociones.Promocion;
import modelo.promociones.PromocionTemporal;
import negocio.GestionDeProductos;
import negocio.GestionDePromociones;
import vistas.IVistaGestion;
import vistas.VistaGestionProductos;
import vistas.VistaGestionPromociones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ControladorGestionPromociones implements ActionListener {

    private static VistaGestionPromociones vistaGestionPromociones;
    private static GestionDePromociones gestionPromociones;

    private static ControladorGestionPromociones controladorGestionPromociones = null;


    private ControladorGestionPromociones() {
        vistaGestionPromociones = new VistaGestionPromociones();
        vistaGestionPromociones.setActionListener(this);
        gestionPromociones = GestionDePromociones.get();
    }

    public static ControladorGestionPromociones getControladorGestionPromociones(boolean mostrar) {
        if (controladorGestionPromociones == null)
            controladorGestionPromociones = new ControladorGestionPromociones();

        Set<Promocion> promociones = gestionPromociones.getPromociones();
        DefaultListModel<Promocion> listaPromociones = new DefaultListModel<>();
        promociones.forEach(listaPromociones::addElement);

        vistaGestionPromociones.setModel(listaPromociones);

        if( mostrar )
            vistaGestionPromociones.mostrar();

        return controladorGestionPromociones;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando =  e.getActionCommand();
        if(comando.equals("Alta Promocion Temporal")) {
            vistaGestionPromociones.esconder();
            ControladorAltaPromocionTemporal con = ControladorAltaPromocionTemporal.getControladorAltaPromocionTemporal();
        }
        else if(comando.equalsIgnoreCase("Alta promocion por producto")){
            vistaGestionPromociones.esconder();
            ControladorAltaPromocionProducto con = ControladorAltaPromocionProducto.getControladorAltaPromocionProducto();
        }
        else  if( comando.equals("Baja Promocion") ){
            Promocion promo = (Promocion) vistaGestionPromociones.getSeleccion();
            try {
                gestionPromociones.bajaPromocion(promo.getId());
                Set<Promocion> promociones = gestionPromociones.getPromociones();
                DefaultListModel<Promocion> updatedList = new DefaultListModel<Promocion>();
                promociones.forEach(updatedList::addElement);
                vistaGestionPromociones.setModel(updatedList);
                vistaGestionPromociones.success("Producto " + promo.getNombre() + "dada de baja");
            } catch (ProductoNoExistenteException ignored) {
            }
        }
        else if( comando.equals("Modificar Promocion") ){
            Promocion promo = (Promocion) vistaGestionPromociones.getSeleccion();
            ControladorAltaPromocionTemporal controladorTemporal;
            ControladorAltaPromocionProducto controladorProducto;
            try {
                gestionPromociones.bajaPromocion(promo.getId());
                if (promo instanceof PromocionTemporal)
                    controladorTemporal = ControladorAltaPromocionTemporal.getControladorAltaPromocionTemporal();
                else
                    controladorProducto = ControladorAltaPromocionProducto.getControladorAltaPromocionProducto();

                vistaGestionPromociones.success("Promocion " + promo.getNombre() + "modificada");
            }
            catch (PromocionNoExistenteException ex) {
            }
        }
        else if( comando.equals("Volver") ){
            vistaGestionPromociones.esconder();
            ControladorInicio controladorInicio = ControladorInicio.getControladorInicio(true);
        }
    }


}
