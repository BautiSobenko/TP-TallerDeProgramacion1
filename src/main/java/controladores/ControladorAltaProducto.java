package controladores;

import dto.ProductoDTO;
import excepciones.ProductoExistenteException;
import negocio.GestionDeProductos;
import vistas.VistaAltaProducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAltaProducto implements ActionListener {
    private static ControladorAltaProducto controladorAltaProducto = null;
    private final GestionDeProductos gestionDeProductos;
    private final VistaAltaProducto vistaAltaProducto;

    private ControladorAltaProducto() {
        this.vistaAltaProducto = new VistaAltaProducto();
        this.vistaAltaProducto.setActionListener(this);
        this.gestionDeProductos = GestionDeProductos.get();
    }

    public static ControladorAltaProducto getControladorAltaProducto() {
        if (controladorAltaProducto == null) {
            controladorAltaProducto = new ControladorAltaProducto();
        }
        controladorAltaProducto.vistaAltaProducto.mostrar();
        return controladorAltaProducto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if( comando.equalsIgnoreCase("Aceptar") ){
            String nombre = this.vistaAltaProducto.getNombre();
            int stock = this.vistaAltaProducto.getStockInicial();
            float precioventa = this.vistaAltaProducto.getPrecioVenta();
            float precioCosto = this.vistaAltaProducto.getPrecioCosto();
            ProductoDTO productoDTO = new ProductoDTO(nombre,precioventa,precioCosto,stock);
            try {
                gestionDeProductos.altaProducto(productoDTO);
                this.vistaAltaProducto.success("El producto se dio de alta con exito");
            } catch (ProductoExistenteException ex) {
                this.vistaAltaProducto.failure("El producto ya se encuentra en el sistema");
            }
            this.vistaAltaProducto.esconder();
        }else if( comando.equalsIgnoreCase("Volver") ){
            this.vistaAltaProducto.esconder();
        }
        ControladorGestionProductos CProd = ControladorGestionProductos.getControladorGestionProductos(true);
    }
}
