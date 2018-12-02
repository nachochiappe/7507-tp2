package fiuba.algo3.Entrega1.PruebasDeEdificios;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.ExcedeTopePoblacionalException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.algoempires.Model.Excepciones.OroInsuficienteException;
import java.util.ArrayList;

public class PlazaCentralTest {
    /*
	@Test
    public void testPlazaCentralSeCreaEnCeroCeroYOcupa2x2() throws FueraDelMapaException{
        Tablero.getInstance().inicializarTablero();
		PlazaCentral plaza = new PlazaCentral();
        Posicion posicionInicial = new Posicion(0,0);
        plaza.construiteEn(posicionInicial);
        Assert.assertTrue(plaza.obtenerPosicionInicial().dentroDe(0,0));
        Assert.assertTrue(plaza.obtenerPosicionFinal().dentroDe(1,1));
    }

	@Test
    public void testDosPlazasCentralesSeCreaEnCeroCeroYOcupa2x2YLaOtraASuDerecha() throws FueraDelMapaException{
        Tablero.getInstance().inicializarTablero();
		PlazaCentral plaza1 = new PlazaCentral();
        Posicion posicionInicial = new Posicion(0,0);
        plaza1.construiteEn(posicionInicial);
        PlazaCentral plaza2 = new PlazaCentral();
        Posicion posicionInicial2 = new Posicion(0,2);
        plaza2.construiteEn(posicionInicial2);
        
        Assert.assertTrue(plaza1.obtenerPosicionInicial().dentroDe(0,0));
        Assert.assertTrue(plaza1.obtenerPosicionFinal().dentroDe(1,1));
        
        Assert.assertTrue(plaza2.obtenerPosicionInicial().dentroDe(0,2));
        Assert.assertTrue(plaza2.obtenerPosicionFinal().dentroDe(1,3));
    }

    @Test
    public void testPlazaCentralCreaAldeanoDevuelveUnAldeano() throws OroInsuficienteException, ExcedeTopePoblacionalException {
        Tablero.getInstance().inicializarTablero();
        JugadorHUD jugador=new JugadorHUD("jugadorTest");
        PlazaCentral plazaCentral= new PlazaCentral();
        Posicion posicion =  new Posicion(18,18);
        Aldeano aldeano=plazaCentral.crearAldeano(jugador,posicion);
        Assert.assertEquals(aldeano.getClass(),Aldeano.class);
    }
    /*
	@Test
    public void testPlazaCentralSeVuelveLugarVacionCuandoQuedaSinVida() {
		Tablero tablero = Mockito.mock(Tablero.class);
		PlazaCentral plaza = new PlazaCentral();
		Espadachin espadachin = Mockito.mock(Espadachin.class);
		Mockito.when(espadachin.cuantoDanioAEdificio()).thenReturn(450);
		plaza.recibeDanioDe(espadachin);
		Assert.assertTrue(LugarVacio.class.isInstance(plaza));
	}*/

    @Test
    public void testPlazaCentralCreaAldeanoSumaUnaUnidadAlJugador() throws OroInsuficienteException, ExcedeTopePoblacionalException {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        PlazaCentral plazaCentral= new PlazaCentral();
        Posicion posicion =  new Posicion(18,18);
        Aldeano aldeano=plazaCentral.crearAldeano(jugador,posicion);
        Assert.assertEquals(aldeano.getClass(),Aldeano.class);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Assert.assertEquals(lista_unidades.size(),4);
    }
    @Test

    public void testPlazaCentralCrearAldeanoRestaOro() throws OroInsuficienteException, ExcedeTopePoblacionalException {
        Jugador jugador = new Jugador("jugador");
        jugador.getPlazaCentral().crearAldeano(jugador, new Posicion(10, 10));
        Assert.assertEquals(jugador.getOro(),75);
    }

    @Test(expected=OroInsuficienteException.class)
    public void testPlazaCentralCrearAldeanoSinOroLanzaExcepcion() throws OroInsuficienteException, ExcedeTopePoblacionalException {
        Jugador jugador = new Jugador("jugador");
        jugador.modificarOro(-100);
        jugador.getPlazaCentral().crearAldeano(jugador, new Posicion(10, 10));
    }
}
