package fiuba.algo3.Entrega1.PruebasDeUnidades;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Test;


public class PruebasDeAtaque {
/*
	@Test
    public void testEspadachinAtacaPlazaCentralYLeBajaVida(){
		Tablero tablero = Mockito.mock(Tablero.class);
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = Mockito.mock(Posicion.class);
		Edificio plaza = new PlazaCentral();
		Espadachin espadachin = new Espadachin(jugador, pos);
		espadachin.atacar(plaza);
		Assert.assertEquals(plaza.obtenerVida(), 435);
	}
	
	@Test
    public void testEspadachinAtacaAOtroEspadachinYLeBajaVida() throws ObjetivoFueraDeRangoException {
		Tablero tablero = Mockito.mock(Tablero.class);
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = new Posicion(4,4);
		Espadachin espadachin = new Espadachin(jugador, pos);
		Espadachin espadachinMalo = new Espadachin(jugador, pos);
		espadachin.atacar(espadachinMalo);
		Assert.assertEquals(espadachinMalo.getHp(), 75);
	}
*/
	@Test(expected = ObjetivoFueraDeRangoException.class)
    public void testEspadachinAtacaAOtroEspadachinQueNoEstaCercaYLevantaExcepcion() throws ObjetivoFueraDeRangoException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Jugador player1 = new Jugador("Pepito");
		Jugador player2 = new Jugador("Fulanito");
		Posicion pos1 = new Posicion(0,0);
		Posicion pos2 = new Posicion(0,3);
		Espadachin espadachinBueno = new Espadachin (player1, pos1);
		Espadachin espadachinMalo = new Espadachin (player2, pos2);
		espadachinBueno.atacar(espadachinMalo);
	}
}
