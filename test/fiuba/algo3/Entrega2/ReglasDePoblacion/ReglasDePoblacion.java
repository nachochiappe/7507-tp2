package fiuba.algo3.Entrega2.ReglasDePoblacion;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Excepciones.ExcedeTopePoblacionalException;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.algoempires.Model.Excepciones.OroInsuficienteException;

public class ReglasDePoblacion {


    @Test
    public void crearUnidadSubePoblacion() throws OroInsuficienteException, ExcedeTopePoblacionalException {
        Jugador jugador = new Jugador("jugador");
        Assert.assertEquals(jugador.obtenerPoblacion(), 3);
        jugador.getPlazaCentral().crearAldeano(jugador, new Posicion(12, 12));
        Assert.assertEquals(jugador.obtenerPoblacion(), 4);
    }

    @Test
    public void matarUnidadBajaPoblacion() throws ObjetivoFueraDeRangoException, OroInsuficienteException, ExcedeTopePoblacionalException {
        Jugador jugador = new Jugador("jugador");
        Jugador otroJugador = new Jugador("jugador malo");
        Aldeano aldeano = jugador.getPlazaCentral().crearAldeano(jugador, new Posicion(12, 12));
        Assert.assertEquals(jugador.obtenerPoblacion(), 4);
        Espadachin espadachin = new Espadachin(otroJugador, new Posicion(12,13));
        Espadachin espadachin2 = new Espadachin(otroJugador, new Posicion(12,11));
        espadachin.atacar(aldeano);
        espadachin2.atacar(aldeano);
        Assert.assertEquals(jugador.obtenerPoblacion(), 3);
    }
    
    @Test
    public void testMatarAldeanoReduceProduccionOro() throws OroInsuficienteException, ExcedeTopePoblacionalException, ObjetivoFueraDeRangoException {
    	Jugador jugador = new Jugador("jugador");
    	Jugador otroJugador = new Jugador("jugador malo");
    	Aldeano aldeano = jugador.getPlazaCentral().crearAldeano(jugador, new Posicion(12, 12));
    	Assert.assertEquals(jugador.obtenerPoblacion(), 4);
    	jugador.sumarOroDelTurno();
    	Assert.assertEquals(155, jugador.getOro());
    	Espadachin espadachin = new Espadachin(otroJugador, new Posicion(12,13));
        Espadachin espadachin2 = new Espadachin(otroJugador, new Posicion(12,11));
        espadachin.atacar(aldeano);
        espadachin2.atacar(aldeano);
        jugador.sumarOroDelTurno();
        Assert.assertEquals(215, jugador.getOro());
    }

    @Test(expected = ExcedeTopePoblacionalException.class)
    public void testNoSePuedeExcederTopePoblacional() throws OroInsuficienteException, ExcedeTopePoblacionalException {
    	Jugador jugador = new Jugador("jugador");
    	jugador.modificarOro(5000);
    	for (int i = 1; i <= 20; i++) {
    		Aldeano aldeano = jugador.getPlazaCentral().crearAldeano(jugador, new Posicion(i, 0));
    	}
    	for (int i = 1; i <= 20; i++) {
    		Aldeano aldeano = jugador.getPlazaCentral().crearAldeano(jugador, new Posicion(0, i));
    	}
    	for (int i = 1; i <= 8; i++) {
    		Aldeano aldeano = jugador.getPlazaCentral().crearAldeano(jugador, new Posicion(i, i));
    	}
    }
}
