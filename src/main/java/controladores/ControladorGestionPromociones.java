package controladores;

import excepciones.ProductoNoExistenteException;
import modelo.Producto;
import modelo.promociones.Promocion;
import negocio.GestionDeProductos;
import vistas.IVistaGestion;
import vistas.VistaGestionProductos;
import vistas.VistaGestionPromociones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ControladorGestionPromociones implements ActionListener {

    private static VistaGestionPromociones vistaGestionPromociones;
    private static GestionPromociones gestionPromociones;

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
        if(comando.equals("Alta Promocion")) {
            vistaGestionPromociones.esconder();

        }
        else  if( comando.equals("Baja Promocion") ){
            Producto producto = (Producto) vistaGestionProductos.getSeleccion();
            try {
                gestionProductos.bajaProducto(producto.getId());
                Set<Producto> productos = gestionProductos.getProductos();
                DefaultListModel<Producto> updatedList = new DefaultListModel<>();
                productos.forEach(updatedList::addElement);
                vistaGestionProductos.setModel(updatedList);
                vistaGestionProductos.success("Producto " + producto.getNombre() + "dada de baja");
            } catch (ProductoNoExistenteException ignored) {
            }
        }
        else if( comando.equals("Modificar Promocion") ){
            Producto producto = (Producto) vistaGestionProductos.getSeleccion();
            try {
                gestionProductos.bajaProducto(producto.getId());
                ControladorAltaProducto controladorAltaProducto = ControladorAltaProducto.getControladorAltaProducto();
                vistaGestionProductos.success("Producto " + producto.getNombre() + "modificado");
            } catch (ProductoNoExistenteException ignored) {
            }
        }
        else if( comando.equals("Volver") ){
            vistaGestionProductos.esconder();
            ControladorInicio controladorInicio = ControladorInicio.getControladorInicio(true);
        }
    }


}
