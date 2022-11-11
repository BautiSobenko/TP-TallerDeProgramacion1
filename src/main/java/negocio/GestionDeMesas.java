package negocio;

import dto.MesaDTO;
import dto.MozoDTO;
import enums.EstadoMesa;
import excepciones.MesaExistenteException;
import excepciones.MesaNoExistenteException;
import modelo.*;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GestionDeMesas {

    private final Empresa empresa;
    private static GestionDeMesas gestionDeMesas = null;
    private Set<Mozo> mozos;

    private GestionDeMesas() {
        this.empresa = Empresa.getEmpresa();
        this.mozos = Empresa.getEmpresa().getMozos();
    }

    public static GestionDeMesas get() {
        if( gestionDeMesas == null )
            gestionDeMesas = new GestionDeMesas();
        return gestionDeMesas;
    }

    /**
     * Persistencia de la coleccion de mesas
     */
    public void persistirMesas(){
        IPersistencia<Set<Mesa>> persistencia = new PersistenciaXML();
        try {
            persistencia.abrirOutput("mesas.xml");
            persistencia.escribir(this.empresa.getMesas());
            persistencia.cerrarOutput();
        } catch (IOException e) {

        }
    }

    /**
     * Carga la mesa ala coleccion
     * precondition: MesaDTO!=null
     * @param mesa
     * @throws MesaExistenteException
     */
    public void altaMesa(MesaDTO mesa) throws MesaExistenteException {

        Set<Mesa> mesas = this.empresa.getMesas();
        boolean existeMesa = mesas.stream().anyMatch(m -> m.getNroMesa() == mesa.getNroMesa() );

        Mesa mesaNueva = new Mesa(mesa.getNroMesa(),mesa.getCantSillas());

        if(!existeMesa){
            mesas.add(mesaNueva);
            persistirMesas();
        }
        else
            throw new MesaExistenteException();
    }

    /**
     * Elimina una mesa recibida y la vuelve a agregar
     * precondition: MesaDTO!=null
     * @param mesa
     */
    public void cerrarMesa(MesaDTO mesa){

        Set<Mesa> mesas = this.empresa.getMesas();
        Iterator<Mesa> it = mesas.iterator();

        Mesa mesaMod = new Mesa(mesa.getNroMesa(),mesa.getCantSillas());

        boolean encontreMesa = false;
        Mesa m = null;

        while(it.hasNext() && !encontreMesa) {
            m = it.next();
            if(m.getNroMesa() == mesaMod.getNroMesa()){
                encontreMesa = true;
            }
        }
        if(encontreMesa) {
            mesas.remove(m);
            m.setEstadoMesa( EstadoMesa.LIBRE );
            m.setMozoAsignado(mesa.getMozoAsignado());
            m.setVentas( mesa.getVentas() + this.totalMesa(m) );
            m.setCantCuentasCerradas( mesa.getCantCuentasCerradas() + 1);
            m.setComanda(null);
            mesas.add(m);
            this.empresa.setMesas(mesas);
        }

    }

    public void modificaMesa(MesaDTO mesa)  {
        Set<Mesa> mesas = this.empresa.getMesas();
        Iterator<Mesa> it = mesas.iterator();

        Mesa mesaMod = new Mesa(mesa.getNroMesa(),mesa.getCantSillas());

        boolean encontreMesa = false;
        Mesa m = null;

        while(it.hasNext() && !encontreMesa) {
            m = it.next();
            if(m.getNroMesa() == mesaMod.getNroMesa()){
                encontreMesa = true;
            }
        }
        if(encontreMesa) {
            mesaMod.setEstadoMesa( mesa.getEstadoMesa() );
            mesaMod.setCantCuentasCerradas( mesa.getCantCuentasCerradas() );
            mesaMod.setComanda(mesa.getComanda());
            mesaMod.setMozoAsignado(mesa.getMozoAsignado());
            mesaMod.setVentas(mesa.getVentas());
            mesas.remove(m);
            mesas.add(mesaMod);
            this.empresa.setMesas(mesas);
            persistirMesas();
        }
    }

    /**
     * Elimina la mesa seleccionada
     * @param nroMesa
     */
    public void bajaMesa(int nroMesa) {
        Set<Mesa> mesas = this.empresa.getMesas();
        Optional<Mesa> mesa = mesas.stream().filter(m -> m.getNroMesa() == nroMesa).findFirst();

        if(mesa.isPresent()){
            mesas.remove(mesa.get());
            this.empresa.setMesas(mesas);
            persistirMesas();
        }
    }

    /**
     * Asigna el mozo enviado a la mesa enviada
     * precondition: MesaDTO!=null && MozoDTO!=null
     * @param mozo
     * @param mesa
     */

    public void asignarMozoMesa(MozoDTO mozo, MesaDTO mesa) {

        boolean existeMozo = this.empresa.getMozos().stream().anyMatch(m -> m.getNombreCompleto().equalsIgnoreCase(mozo.getNombreCompleto()) );
        Set<Mesa> mesas = this.empresa.getMesas();
        boolean existeMesa = mesas.stream().anyMatch(m -> m.getNroMesa() == mesa.getNroMesa());

            if( existeMesa ){
                Mesa mesaM = new Mesa(mesa.getNroMesa(), mesa.getCantSillas());
                Mozo mozoA = new Mozo(mozo.getNombreCompleto(),mozo.getFechaNacimiento(),mozo.getCantidadHijos());
                mesas.removeIf(m -> m.getNroMesa() == mesaM.getNroMesa());
                mesaM.setMozoAsignado(mozoA);
                mesas.add(mesaM);
                this.empresa.setMesas(mesas);
            }
    }

    /**
     * Cierra la mesa enviada
     * precondition: mesa!=null
     * @param mesa
     * @return
     */
    public double totalMesa(Mesa mesa){

        List<Pedido> pedidosMesa = mesa.getComanda().getPedidos();

        return pedidosMesa.stream()
                .mapToDouble(p -> p.getProducto().getPrecio() * p.getCantidad() )
                .sum() ;

    }

    public Set<Mesa> getMesas(){
        return this.empresa.getMesas();
    }

    /**
     * trae el consumo promedio de una mesa
     * @param nroMesa
     * @return consumo promedio de la mesa enviada
     * @throws MesaNoExistenteException
     */
    public float calculaConsumoPromedio(int nroMesa) throws MesaNoExistenteException {
        return (float) empresa.consumoPromedioMesa(nroMesa);
    }

    public Set<Mozo> getMozos() {
        return mozos;
    }

    public void setMozos(Set<Mozo> mozos) {
        this.mozos = mozos;
    }
}
