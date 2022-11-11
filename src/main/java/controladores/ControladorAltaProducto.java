package controladores;

import dto.ProductoDTO;
import excepciones.CambioNombreException;
import excepciones.ProductoExistenteException;
import modelo.Producto;
import negocio.GestionDeProductos;
import vistas.VistaAltaProducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAltaProducto implements ActionListener {
    private static ControladorAltaProducto controladorAltaProducto = null;
    private final GestionDeProductos gestionDeProductos;
    private final VistaAltaProducto vistaAltaProducto;
    private String op;
    private Producto producto;

    private ControladorAltaProducto() {
        this.vistaAltaProducto = new VistaAltaProducto();
        this.vistaAltaProducto.setActionListener(this);
        this.gestionDeProductos = GestionDeProductos.get();
    }

    public static ControladorAltaProducto getControladorAltaProducto(String op) {
        if (controladorAltaProducto == null) {
            controladorAltaProducto = new ControladorAltaProducto();
        }
        controladorAltaProducto.op = op;
        controladorAltaProducto.vistaAltaProducto.mostrar();

        return controladorAltaProducto;
    }

    public static ControladorAltaProducto getControladorAltaProducto(String op, Producto producto) {
        if (controladorAltaProducto == null) {
            controladorAltaProducto = new ControladorAltaProducto();
        }
        controladorAltaProducto.op = op;
        controladorAltaProducto.producto = producto;
        controladorAltaProducto.vistaAltaProducto.mostrar();

        return controladorAltaProducto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        ControladorAltaProducto con;

        if( comando.equalsIgnoreCase("Aceptar") ){
            String nombre = this.vistaAltaProducto.getNombre();
            int stock = this.vistaAltaProducto.getStockInicial();
            float precioventa = this.vistaAltaProducto.getPrecioVenta();
            float precioCosto = this.vistaAltaProducto.getPrecioCosto();
            if( stock == 0 || precioCosto==0 || precioventa==0){
                if(op.equalsIgnoreCase("Alta"))
                    ControladorAltaProducto.getControladorAltaProducto(op);
                else
                    ControladorAltaProducto.getControladorAltaProducto(op,producto);
            }
            else {
                ProductoDTO productoDTO = new ProductoDTO(nombre, precioventa, precioCosto, stock);
                    if(op.equalsIgnoreCase("Alta")){
                        try {
                            gestionDeProductos.altaProducto(productoDTO);
                            this.vistaAltaProducto.success("El producto: " + productoDTO.getNombre() + " fue dado de alta con exito");
                            this.vistaAltaProducto.esconder();
                            ControladorGestionProductos CProd = ControladorGestionProductos.getControladorGestionProductos(true);
                        }catch (ProductoExistenteException ex) {
                            this.vistaAltaProducto.failure("El producto: " + productoDTO.getNombre() + " ya se encuentra en el sistema");
                            this.vistaAltaProducto.esconder();
                            ControladorGestionProductos CProd = ControladorGestionProductos.getControladorGestionProductos(true);
                        }
                    }else{
                        try {
                            gestionDeProductos.modificaProducto(productoDTO);
                            this.vistaAltaProducto.success("El producto: " + productoDTO.getNombre() + " fue modificado con exito");
                            this.vistaAltaProducto.esconder();
                            ControladorGestionProductos CProd = ControladorGestionProductos.getControladorGestionProductos(true);
                        }
                        catch (CambioNombreException ex) {
                            this.vistaAltaProducto.failure("No se puede cambiar el nombre del producto a modificar");
                            vistaAltaProducto.limpia();
                            ControladorAltaProducto.getControladorAltaProducto(op,producto);
                        }
                    }
            }
        }else if( comando.equalsIgnoreCase("Volver") ){
            this.vistaAltaProducto.esconder();
            ControladorGestionProductos CProd = ControladorGestionProductos.getControladorGestionProductos(true);
        }
    }
}
