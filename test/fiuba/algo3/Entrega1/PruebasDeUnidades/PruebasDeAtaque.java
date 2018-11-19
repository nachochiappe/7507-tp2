package fiuba.algo3.Entrega1.PruebasDeUnidades;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import pruebas.MockitoTest.IPersona;

import static org.mockito.Mockito.mock;

public class PruebasDeAtaque {

	@Test
    public void testEspadachinAtacaPlazaCentralYLeBajaVida(){
		Tablero tablero = Mockito.mock(Tablero.class);
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = Mockito.mock(Posicion.class);
		Edificio plaza = new PlazaCentral(tablero);
		Espadachin espadachin = new Espadachin(tablero, jugador, pos);
		espadachin.atacar(plaza);
		Assert.assertEquals(plaza.obtenerVida(), 435);
	}
	
	@Test
    public void testEspadachinAtacaAOtroEspadachinYLeBajaVida() throws ObjetivoFueraDeRangoException {
		Tablero tablero = Mockito.mock(Tablero.class);
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = new Posicion(4,4);
		Espadachin espadachin = new Espadachin(tablero, jugador, pos);
		Espadachin espadachinMalo = new Espadachin(tablero, jugador, pos);
		espadachin.atacar(espadachinMalo);
		Assert.assertEquals(espadachinMalo.getHp(), 75);
	}

	@Test(expected = ObjetivoFueraDeRangoException.class)
    public void testEspadachinAtacaAOtroEspadachinQueNoEstaCercaYLevantaExcepcion() throws ObjetivoFueraDeRangoException {
		Tablero tablero = new Tablero();
		Jugador player1 = new Jugador("Pepito", tablero);
		Jugador player2 = new Jugador("Fulanito", tablero);
		Posicion pos1 = new Posicion(0,0);
		Posicion pos2 = new Posicion(0,3);
		Espadachin espadachinBueno = new Espadachin (tablero, player1, pos1);
		Espadachin espadachinMalo = new Espadachin (tablero, player2, pos2);
		espadachinBueno.atacar(espadachinMalo);
	}
}
