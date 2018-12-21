package fiuba.algo3.Entrega1.PruebasDeEdificios;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.LugarVacio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.ExcedeTopePoblacionalException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.JugadorHUD.JugadorHUD;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import fiuba.algo3.algoempires.Model.Excepciones.OroInsuficienteException;
import fiuba.algo3.algoempires.Model.Excepciones.PosicionOcupadaException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;

import java.util.ArrayList;

public class PlazaCentralTest {

	@Test
    public void testPlazaCentralSeCreaEnCeroCeroYOcupa2x2() throws FueraDelMapaException, SoloSePermiteUnAldeanoException, OroInsuficienteException, PosicionOcupadaException{
        Tablero.getInstance().inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
		PlazaCentral plaza = new PlazaCentral();
        Posicion posicionInicial = new Posicion(0,1);
        plaza.construiteEn(new Aldeano(jugador, new Posicion (0,0)), posicionInicial);
        Assert.assertTrue(plaza.obtenerPosicionInicial().dentroDe(0,1));
        Assert.assertTrue(plaza.obtenerPosicionFinal().dentroDe(1,2));
    }

	@Test
    public void testDosPlazasCentralesSeCreaEnCeroCeroYOcupa2x2YLaOtraASuDerecha() throws FueraDelMapaException, SoloSePermiteUnAldeanoException, OroInsuficienteException, PosicionOcupadaException{
        Tablero.getInstance().inicializarTablero();
		PlazaCentral plaza1 = new PlazaCentral();
		Jugador jugador = new Jugador("Jugador Test");
		jugador.modificarOro(10000);
		Posicion posicionInicial = new Posicion(0,0);
        plaza1.construiteEn(new Aldeano(jugador, new Posicion (0,0)), posicionInicial);
        PlazaCentral plaza2 = new PlazaCentral();
        Posicion posicionInicial2 = new Posicion(0,4);
        plaza2.construiteEn(new Aldeano(jugador, new Posicion (0,3)), posicionInicial2);
        
        Assert.assertTrue(plaza1.obtenerPosicionInicial().dentroDe(0,1));
        Assert.assertTrue(plaza1.obtenerPosicionFinal().dentroDe(1,2));
        
        Assert.assertTrue(plaza2.obtenerPosicionInicial().dentroDe(0,4));
        Assert.assertTrue(plaza2.obtenerPosicionFinal().dentroDe(1,5));
    }

    @Test
    public void testPlazaCentralCreaAldeanoDevuelveUnAldeano() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        PlazaCentral plazaCentral= new PlazaCentral();
        plazaCentral.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad aldeano=plazaCentral.crearUnidad(new Aldeano(jugador,posicion),posicion);
        Assert.assertEquals(aldeano.getClass(),Aldeano.class);
    }

	@Test
    public void testPlazaCentralSeVuelveLugarVacionCuandoQuedaSinVida() {
		Tablero tablero = Mockito.mock(Tablero.class);
		PlazaCentral plaza = new PlazaCentral(new Posicion(0,0), new Jugador("hola"));
		Ofensiva espadachin = Mockito.mock(Espadachin.class);
		Mockito.when(espadachin.cuantoDanioAEdificio()).thenReturn(450);
		plaza.recibeDanioDe(espadachin);
		Assert.assertTrue(plaza.getJugador() == null);
	}

    @Test
    public void testPlazaCentralCreaAldeanoSumaUnaUnidadAlJugador() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        PlazaCentral plazaCentral= new PlazaCentral();
        plazaCentral.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad aldeano=plazaCentral.crearUnidad(new Aldeano(jugador, posicion),posicion);
        Assert.assertEquals(aldeano.getClass(),Aldeano.class);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Assert.assertEquals(lista_unidades.size(),4);
    }
    @Test

    public void testPlazaCentralCrearAldeanoRestaOro() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
        Jugador jugador = new Jugador("jugador");
        PlazaCentral plazaCentral= new PlazaCentral();
        plazaCentral.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad aldeano = plazaCentral.crearUnidad(new Aldeano(jugador, posicion), new Posicion(17,18));
        Assert.assertEquals(jugador.getOro(),75);
    }

    @Test(expected=OroInsuficienteException.class)
    public void testPlazaCentralCrearAldeanoSinOroLanzaExcepcion() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
        Jugador jugador = new Jugador("jugador");
        jugador.modificarOro(-100);
        PlazaCentral plazaCentral= new PlazaCentral();
        plazaCentral.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad aldeano = plazaCentral.crearUnidad(new Aldeano(jugador, posicion), posicion);
    }
}
