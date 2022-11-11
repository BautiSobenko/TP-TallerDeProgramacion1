package negocio;

import dto.PromocionDTO;
import dto.PromocionProductoDTO;
import dto.PromocionTemporalDTO;
import excepciones.PromocionExistenteException;
import modelo.Empresa;
import modelo.promociones.Promocion;
import modelo.promociones.PromocionFija;
import modelo.promociones.PromocionTemporal;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

import java.io.IOException;
import java.util.Iterator;
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
            persistencia.escribir(this.empresa.getPromociones());
            persistencia.cerrarOutput();
        } catch (IOException e) {

        }
    }

    public void altaPromocion(PromocionDTO promocion) throws PromocionExistenteException {
        PromocionTemporal promoTemporal;
        PromocionFija promoFija;
        Set<Promocion> promociones = this.getPromociones();

        Iterator<Promocion> it = promociones.iterator();
        boolean encontrePromo = false;
        Promocion p = null;

        while(it.hasNext() && !encontrePromo) {
            p = it.next();
            if( (p instanceof PromocionFija && promocion instanceof PromocionProductoDTO) || (p instanceof PromocionTemporal && promocion instanceof PromocionTemporalDTO) ){
                if( p.getNombre().equals(promocion.getNombre()) )
                    encontrePromo = true;
            }
        }

        if(!encontrePromo){

            if(promocion instanceof PromocionTemporalDTO promo){
                promoTemporal = new PromocionTemporal(promo.getNombre(),
                        promo.getDiasPromo(),
                        promo.getFormaPago(),
                        promo.getPorcentajeDescuento(),
                        promo.isAcumulable());

                promociones.add(promoTemporal);
            }
            else if (promocion instanceof PromocionProductoDTO promo){
                promoFija = new PromocionFija(promo.getNombre(),
                        promo.getDiasPromo(),
                        promo.getProducto(),
                        promo.isDosPorUno(),
                        promo.isDtoPorCant(),
                        promo.getDtoPorCantMin(),
                        promo.getDtoPorCantPrecioU());

                promociones.add(promoFija);
            }

            this.empresa.setPromociones(promociones);
            persistirPromociones();
        } else{
            if( p instanceof PromocionFija)
                throw new PromocionExistenteException("Ya existe una promocion fija con el nombre " + p.getNombre());
            else
                throw new PromocionExistenteException("Ya existe una promocion temporal con el nombre " + p.getNombre());
        }

    }

    public void modificaPromocion(PromocionDTO promocion) {
        Set<Promocion> promociones = this.getPromociones();

        Iterator<Promocion> it = promociones.iterator();
        boolean encontrePromo = false;
        Promocion p = null;

        while(it.hasNext() && !encontrePromo) {
            p = it.next();
            if( (p instanceof PromocionFija && promocion instanceof PromocionProductoDTO) || (p instanceof PromocionTemporal && promocion instanceof PromocionTemporalDTO) ){
                if( p.getNombre().equals(promocion.getNombre()) )
                    encontrePromo = true;
            }
        }

        if(encontrePromo){

            promociones.remove(p);

            if(promocion instanceof PromocionTemporalDTO promo){
                PromocionTemporal promoTemporal = new PromocionTemporal(promo.getNombre(),
                                                                        promo.getDiasPromo(),
                                                                        promo.getFormaPago(),
                                                                        promo.getPorcentajeDescuento(),
                                                                        promo.isAcumulable());

                promociones.add(promoTemporal);
            }
            else if (promocion instanceof PromocionProductoDTO promo){
                PromocionFija promoFija = new PromocionFija(promo.getNombre(),
                                                            promo.getDiasPromo(),
                                                            promo.getProducto(),
                                                            promo.isDosPorUno(),
                                                            promo.isDtoPorCant(),
                                                            promo.getDtoPorCantMin(),
                                                            promo.getDtoPorCantPrecioU());

                promociones.add(promoFija);
            }

            this.empresa.setPromociones(promociones);
            persistirPromociones();
        }
    }

    public void bajaPromocion(PromocionDTO promocion) {
        Set<Promocion> promociones = this.getPromociones();

        Iterator<Promocion> it = promociones.iterator();
        boolean encontrePromo = false;
        Promocion p = null;

        while (it.hasNext() && !encontrePromo) {
            p = it.next();
            if ((p instanceof PromocionFija && promocion instanceof PromocionProductoDTO) || (p instanceof PromocionTemporal && promocion instanceof PromocionTemporalDTO)) {
                if (p.getNombre().equals(promocion.getNombre()))
                    encontrePromo = true;
            }
        }

        if (encontrePromo) {
            promociones.remove(p);
            this.empresa.setPromociones(promociones);
            persistirPromociones();
        }
    }


}
