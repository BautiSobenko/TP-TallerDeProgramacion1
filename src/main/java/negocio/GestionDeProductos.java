package negocio;

import excepciones.ProductoExistenteException;
import excepciones.ProductoNoExistenteException;
import modelo.Empresa;
import modelo.Producto;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class GestionDeProductos {

    private final Empresa empresa;
    private static GestionDeProductos gestionDeProductos = null;

    private GestionDeProductos() {
        this.empresa = Empresa.getEmpresa();
    }

    public static GestionDeProductos get() {
        if( gestionDeProductos == null )
            gestionDeProductos = new GestionDeProductos();
        return gestionDeProductos;
    }

    public void persistirProductos(){
        IPersistencia<Set<Producto>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("productos.xml");
            persistencia.escribir(this.empresa.getProductos());
            persistencia.cerrarOutput();
        } catch (IOException e) {

        }
    }

    private void altaProducto(Producto producto) throws ProductoExistenteException {
        Set<Producto> productos = this.empresa.getProductos();
        boolean existeProducto = productos.stream().anyMatch(p -> p.getId().equals(producto.getId()));


        if(!existeProducto){
            productos.add(producto);
            this.empresa.setProductos(productos);
            persistirProductos();
        }
        else
            throw new ProductoExistenteException();
    }

    private void modificaProducto(Producto producto) throws ProductoNoExistenteException {
        Set<Producto> productos = this.empresa.getProductos();
        Iterator<Producto> it = productos.iterator();

        boolean encontreProducto = false;
        Producto prod = null;

        while(it.hasNext() && !encontreProducto) {
            prod = it.next();
            if(prod.getId().equals(producto.getId())){
                encontreProducto = true;
            }
        }
        if(encontreProducto) {
            productos.remove(prod);
            productos.add(producto);
            this.empresa.setProductos(productos);
            persistirProductos();
        }
        else
            throw new ProductoNoExistenteException();
    }

    private void bajaProducto(String id) throws ProductoNoExistenteException {
        Set<Producto> productos = this.empresa.getProductos();
        Iterator<Producto> it = productos.iterator();
        boolean encontreProducto = false;
        Producto prod = null;

        while(it.hasNext() && !encontreProducto) {
            prod = it.next();
            if(prod.getId().equals(id)){
                encontreProducto = true;
            }
        }
        if(encontreProducto){
            productos.remove(prod);
            this.empresa.setProductos(productos);
            persistirProductos();
        }
        else
            throw new ProductoNoExistenteException();
    }

}
