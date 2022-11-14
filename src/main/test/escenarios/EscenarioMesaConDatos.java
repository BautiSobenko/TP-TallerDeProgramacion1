package escenarios;

import enums.EstadoMesa;
import modelo.Empresa;
import modelo.Mesa;
import modelo.Producto;

import java.util.HashSet;
import java.util.Set;

public class EscenarioMesaConDatos {


    private Set<Mesa> mesas = new HashSet<>();
    private Set<Producto> productos = new HashSet<>();
    Empresa empresa;

    {
        empresa = Empresa.getEmpresa();
        Mesa mesa = new Mesa(10, 5);
        mesa.setEstadoMesa(EstadoMesa.LIBRE);
        mesas.add(mesa);
        Producto prod = new Producto("Morcilla",90,25,30);
        productos.add(prod);
        empresa.setMesas(mesas);
        empresa.setProductos(productos);
    }

    public Set<Mesa> getMesas(){
        return mesas;
    }

    public Set<Producto> getProductos(){
        return productos;
    }

}
