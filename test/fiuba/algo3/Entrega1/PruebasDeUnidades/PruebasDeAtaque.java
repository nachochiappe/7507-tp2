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
    public void testEspadachinAtacaAOtroEspadachinYLeBajaVida() {
		Tablero tablero = Mockito.mock(Tablero.class);
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = Mockito.mock(Posicion.class);
		Espadachin espadachin = new Espadachin(tablero, jugador, pos);
		Espadachin espadachinMalo = new Espadachin(tablero, jugador, pos);
		espadachin.atacar(espadachinMalo);
		Assert.assertEquals(espadachinMalo.getHp(), 75);
	}
	
}
