package negocio;

import dto.ProductoDTO;
import enums.EstadoMesa;
import modelo.Comanda;
import modelo.Empresa;
import modelo.Mesa;
import modelo.Pedido;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GestionDeComandas {

    private final Empresa empresa;
    private static GestionDeComandas gestionDeComandas = null;

    private GestionDeComandas() {
        this.empresa = Empresa.getEmpresa();
    }

    public static GestionDeComandas get() {
        if( gestionDeComandas == null )
            gestionDeComandas = new GestionDeComandas();

        return gestionDeComandas;
    }

    public void abrirComanda(Mesa mesa){

        Set<Mesa> mesas = empresa.getMesas();

        mesas.remove(mesa);
        mesa.setComanda(new Comanda(mesa));
        mesa.setEstadoMesa(EstadoMesa.OCUPADA);
        mesas.add(mesa);
        this.empresa.setMesas(mesas);

    }

    public void cargarPedido(Mesa mesa,  Pedido pedido){

        Set<Mesa> mesas = empresa.getMesas();
        Iterator<Mesa> it = mesas.iterator();

        Comanda comanda = mesa.getComanda();
        if(GestionDeProductos.get().descuentarStock( pedido )){
            comanda.getPedidos().add(pedido);
            mesas.remove(mesa);
            mesa.setComanda( comanda );
            mesas.add(mesa);
            this.empresa.setMesas(mesas);
        }else{
            //!Throw excepcion No hay stock disponible del producto
        }
        }
    }
