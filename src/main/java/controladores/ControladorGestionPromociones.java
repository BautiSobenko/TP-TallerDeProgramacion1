package controladores;

import dto.PromocionProductoDTO;
import dto.PromocionTemporalDTO;
import excepciones.ProductoNoExistenteException;
import excepciones.PromocionExistenteException;
import modelo.promociones.Promocion;
import modelo.promociones.PromocionFija;
import modelo.promociones.PromocionTemporal;
import negocio.GestionDePromociones;
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

        Promocion promocion = (Promocion) vistaGestionPromociones.getSeleccion();
        PromocionTemporalDTO promocionTemporalDTO = null;
        PromocionProductoDTO promocionProductoDTO = null;

        if( promocion instanceof PromocionTemporal ){
            PromocionTemporal promocionTemporal = (PromocionTemporal) promocion;
            promocionTemporalDTO = new PromocionTemporalDTO(   promocionTemporal.getNombre(),
                    promocionTemporal.isActivo(),
                    promocionTemporal.getDiasPromo(),
                    promocionTemporal.getFormaPago(),
                    promocionTemporal.getPorcentajeDescuento(),
                    promocionTemporal.isEsAcumulable());
        }else{
            PromocionFija promocionFija = (PromocionFija) promocion;
            promocionProductoDTO = new PromocionProductoDTO(   promocionFija.getNombre(),
                    promocionFija.isActivo(),
                    promocionFija.getDiasPromo(),
                    promocionFija.getProducto(),
                    promocionFija.isDosPorUno(),
                    promocionFija.isDtoPorCant(),
                    promocionFija.getDtoPorCantMin(),
                    promocionFija.getDtoPorCantPrecioU());
        }

        if(comando.equals("Alta Promocion Temporal")) {
            vistaGestionPromociones.esconder();
            ControladorAltaPromocionTemporal con = ControladorAltaPromocionTemporal.getControladorAltaPromocionTemporal();
        }
        else if(comando.equalsIgnoreCase("Alta promocion por producto")){
            vistaGestionPromociones.esconder();
            ControladorAltaPromocionProducto con = ControladorAltaPromocionProducto.getControladorAltaPromocionProducto();
        }
        else  if( comando.equals("Baja Promocion") ){

           if( promocion instanceof PromocionTemporal ) {
               gestionPromociones.bajaPromocion(promocionTemporalDTO);
               vistaGestionPromociones.success("Promocion temporal: " + promocionTemporalDTO.getNombre() + "dada de baja");
           }else{
               gestionPromociones.bajaPromocion(promocionProductoDTO);
               vistaGestionPromociones.success("Promocion producto: " + promocionProductoDTO.getNombre() + "dada de baja");
           }

            Set<Promocion> promociones = gestionPromociones.getPromociones();
            DefaultListModel<Promocion> updatedList = new DefaultListModel<Promocion>();
            promociones.forEach(updatedList::addElement);
            vistaGestionPromociones.setModel(updatedList);
        }
        else if( comando.equals("Modificar Promocion") ){

            ControladorAltaPromocionTemporal controladorTemporal;
            ControladorAltaPromocionProducto controladorProducto;
           // try {
               // gestionPromociones.bajaPromocion(promo.getId());
              //  if (promo instanceof PromocionTemporal)
                    controladorTemporal = ControladorAltaPromocionTemporal.getControladorAltaPromocionTemporal();
              //  else
                    controladorProducto = ControladorAltaPromocionProducto.getControladorAltaPromocionProducto();

              //  vistaGestionPromociones.success("Promocion " + promo.getNombre() + "modificada");
           // }
          //  catch (PromocionExistenteException ex) {
           // }
        }
        else if( comando.equals("Volver") ){
            vistaGestionPromociones.esconder();
            ControladorInicio controladorInicio = ControladorInicio.getControladorInicio(true);
        }
    }

}
