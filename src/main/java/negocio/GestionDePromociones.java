package negocio;

import dto.ProductoDTO;
import dto.PromocionTemporalDTO;
import excepciones.ProductoExistenteException;
import modelo.Empresa;
import modelo.Operario;
import modelo.Producto;
import modelo.promociones.Promocion;
import modelo.promociones.PromocionFija;
import modelo.promociones.PromocionTemporal;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

import java.io.IOException;
import java.util.Set;

public class GestionDePromociones {

    private final Empresa empresa;
    private static GestionDePromociones gestionDePromociones = null;

    private GestionDePromociones() {

        this.empresa = Empresa.getEmpresa();
    }

    public static GestionDePromociones get() {
        if( gestionDePromociones == null )
            gestionDePromociones = new GestionDePromociones();
        return gestionDePromociones;
    }

    public Set<Promocion> getPromociones(){
        return this.empresa.getPromociones();
    }

    public void persistirPromociones(){
        IPersistencia<Set<Promocion>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("promociones.xml");
            persistencia.escribir(this.getPromociones());
            persistencia.cerrarOutput();
        } catch (IOException e) {

        }
    }

    public void altaProducto(PromocionDTO promocion) throws ProductoExistenteException {
        Set<Promocion> promociones = this.getPromociones();
        if(promocion instanceof PromocionTemporalDTO){
            PromocionTemporal promoTemporal = new PromocionTemporal();
        }
        else if ( promocion instanceof PromocionFijaDTO ){
            PromocionFija promoFija = new PromocionFija();
        }
        Producto productoNuevo = new Producto(producto.getNombre(), producto.getPrecio(), producto.getCosto(), producto.getStock());
        boolean existePromo = promociones.stream().anyMatch(p -> p.getId().equals(productoNuevo.getId()));

        if(!existeProducto){
            productos.add(productoNuevo);
            this.empresa.setProductos(productos);
            persistirProductos();
        }
        else
            throw new ProductoExistenteException();
    }



}
