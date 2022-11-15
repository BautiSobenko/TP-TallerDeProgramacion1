package negocio;

import enums.Dias;
import escenarios.EscenarioMesaConDatos;
import escenarios.EscenarioPromocionesCargadas;
import junit.framework.TestCase;
import modelo.Producto;
import modelo.promociones.PromocionFija;
import modelo.promociones.PromocionTemporal;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class GestionDePromocionesTest extends TestCase {

    private EscenarioPromocionesCargadas escenario;
    private GestionDePromociones gestionDePromociones;

    @Before
    public void setUp() throws Exception {
        this.gestionDePromociones = GestionDePromociones.get();
        escenario = new EscenarioPromocionesCargadas();
        escenario.aplicarEscenarioPromocionesCargadas();
    }

    public void testIsDiaIncluido() {

        Producto prod = escenario.getProd();
        PromocionFija promoFija = escenario.getPromoFija();

        boolean estaIncluido = gestionDePromociones.isDiaIncluido(promoFija,"Lunes");

        assertEquals("El dia deberia estar incluido en la promocion",estaIncluido,true);

        PromocionTemporal promocionTemporal = escenario.getPromoTemporal();
        estaIncluido = gestionDePromociones.isDiaIncluido(promocionTemporal,"Lunes");

        assertNotEquals("El dia no deberia estar incluido en la promocion",estaIncluido,true);

    }

    public void testHayPromocionesHoy() {
        assertEquals("No deberia estar disponible abrir el local",gestionDePromociones.hayPromocionesHoy(),true);
    }



}