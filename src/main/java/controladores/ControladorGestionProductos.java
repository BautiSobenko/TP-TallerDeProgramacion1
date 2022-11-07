package controladores;

import excepciones.MesaNoExistenteException;
import excepciones.ProductoNoExistenteException;
import modelo.Mesa;
import modelo.Producto;
import negocio.GestionDeMesas;
import negocio.GestionDeProductos;
import vistas.IVistaGestion;
import vistas.VistaGestionMesas;
import vistas.VistaGestionProductos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ControladorGestionProductos implements ActionListener {

    private static IVistaGestion vistaGestionProductos;
    private static GestionDeProductos gestionProductos;

    private static ControladorGestionProductos controladorGestionProductos = null;


    private ControladorGestionProductos() {
        vistaGestionProductos = new VistaGestionProductos();
        vistaGestionProductos.setActionListener(this);
        gestionProductos = GestionDeProductos.get();
    }

    public static ControladorGestionProductos getControladorGestionProductos(boolean mostrar) {
        if (controladorGestionProductos == null)
            controladorGestionProductos = new ControladorGestionProductos();

        Set<Producto> productos = gestionProductos.getProductos();
        DefaultListModel<Producto> listaProductos = new DefaultListModel<>();
        productos.forEach(listaProductos::addElement);

        ControladorGestionProductos.vistaGestionProductos.setModel(listaProductos);

        if( mostrar )
            vistaGestionProductos.mostrar();

        return controladorGestionProductos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando =  e.getActionCommand();
        if(comando.equals("Alta Producto")) {
            vistaGestionProductos.esconder();
            //!ControladorAltaOperario controladorAltaOperario = ControladorAltaOperario.getControladorAltaOperario(true);
        }else
        if( comando.equals("Baja Producto") ){
            Producto producto = (Producto) vistaGestionProductos.getSeleccion();
            try {
                gestionProductos.bajaProducto(producto.getId());
                vistaGestionProductos.success("Producto " + producto.getNombre() + "dada de baja");
            } catch (ProductoNoExistenteException ignored) {
            }
        }
        else{
            Producto producto = (Producto) vistaGestionProductos.getSeleccion();
            try {
                gestionProductos.bajaProducto(producto.getId());
                //!ControladorAltaOperario controladorAltaOperario = ControladorAltaOperario.getControladorAltaOperario(true);
                vistaGestionProductos.success("Producto " + producto.getNombre() + "modificado");
            } catch (ProductoNoExistenteException ignored) {
            }
        }
    }

}
