package negocio;

import dto.MesaDTO;
import escenarios.EscenarioMesaConDatos;
import excepciones.MesaExistenteException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class GestionDeMesasTest {

    private EscenarioMesaConDatos escenario;
    private GestionDeMesas gestionDeMesas;

    @Before
    public void setUp() throws Exception {
        this.gestionDeMesas = GestionDeMesas.get();
        escenario = new EscenarioMesaConDatos();
    }

    @Test
    public void altaMesaOk() {

        MesaDTO mesaDTO = new MesaDTO( 1 , 3 );
        try {
            this.gestionDeMesas.altaMesa(mesaDTO);
        } catch (MesaExistenteException ignored) {

        }
        Boolean seAgrego = this.gestionDeMesas.getMesas().stream().anyMatch( m -> m.getNroMesa() == mesaDTO.getNroMesa() );
        assertEquals( "La mesa no se ha agregado", seAgrego, true );

    }

    @Test
    public void altaMesaFail() {

        MesaDTO mesaDTO = new MesaDTO( 10 , 5 );

        assertThrows( "No ha lanzado correctamente la excepcion", MesaExistenteException.class, () -> this.gestionDeMesas.altaMesa(mesaDTO));

    }

    @Test
    public void cerrarMesa() {
    }

    @Test
    public void modificaMesa() {
    }

    @Test
    public void bajaMesa() {
    }

    @Test
    public void asignarMozoMesa() {
    }

    @Test
    public void totalMesa() {
    }

    @Test
    public void calculaConsumoPromedio() {
    }
}