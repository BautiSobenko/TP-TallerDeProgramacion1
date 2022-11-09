package negocio;

import modelo.Empresa;
import modelo.Operario;
import modelo.promociones.Promocion;

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
        return this.empresa.getP;
    }
}
