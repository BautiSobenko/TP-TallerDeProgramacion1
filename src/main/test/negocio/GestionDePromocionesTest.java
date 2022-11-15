package negocio;

import enums.Dias;
import escenarios.EscenarioMesaConDatos;
import escenarios.EscenarioPromocionesCargadas;
import escenarios.EscenarioSinPromos;
import junit.framework.TestCase;
import modelo.Producto;
import modelo.promociones.PromocionFija;
import modelo.promociones.PromocionTemporal;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class GestionDePromocionesTest extends TestCase {

    private EscenarioPromocionesCargadas escenario;
    private GestionDePromociones gestionDePromociones;
    private EscenarioSinPromos escenario2;

    @Before
    public void setUp() throws Exception {
        this.gestionDePromociones = GestionDePromociones.get();
        escenario = new EscenarioPromocionesCargadas();
        escenario2 = new EscenarioSinPromos();
    }

    public void tearDown1(){
        escenario.borrarEscenario();
    }

    public void tearDown2(){
        escenario2.borrarEscenario();
    }

    public void testIsDiaIncluido() {

        escenario.aplicarEscenarioPromocionesCargadas();
        Producto prod = escenario.getProd();
        PromocionFija promoFija = escenario.getPromoFija();

        boolean estaIncluido = gestionDePromociones.isDiaIncluido(promoFija,"Lunes");

        assertEquals("El dia deberia estar incluido en la promocion",estaIncluido,true);

        PromocionTemporal promocionTemporal = escenario.getPromoTemporal();
        estaIncluido = gestionDePromociones.isDiaIncluido(promocionTemporal,"Lunes");

        assertNotEquals("El dia no deberia estar incluido en la promocion",estaIncluido,true);

        tearDown1();
    }

    public void testHayPromocionesHoy() {
        escenario.aplicarEscenarioPromocionesCargadas();
        assertEquals("No deberia estar disponible abrir el local",gestionDePromociones.hayPromocionesHoy(),true);
        tearDown1();
    }

    public void testHayPromocionesHoyFail() {
        escenario2.aplicarEscenarioSinPromos();
        assertEquals("No deberia estar disponible abrir el local",gestionDePromociones.hayPromocionesHoy(),false);
        tearDown2();
    }


}