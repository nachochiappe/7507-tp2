package fiuba.algo3.algoempires.Deprecated;
/*
import static org.junit.Assert.*;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import fiuba.algo3.algoempires.Model.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Test;

public class EspadachinTest {

	@Test
	public void testEspadachinSeMueveParaArribaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(10, 11);
		Espadachin espadachin = new Espadachin(tablero, posicion);
		espadachin.moverArriba();
		Assert.assertEquals(espadachin.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testEspadachinSeMueveParaAbajoUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(10, 9);
		Espadachin espadachin = new Espadachin(tablero, posicion);
		espadachin.moverAbajo();
		Assert.assertEquals(espadachin.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testEspadachinSeMueveParaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 10);
		Espadachin espadachin = new Espadachin(tablero, posicion);
		espadachin.moverIzquierda();
		Assert.assertEquals(espadachin.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testEspadachinSeMueveParaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 10);
		Espadachin espadachin = new Espadachin(tablero, posicion);
		espadachin.moverDerecha();
		Assert.assertEquals(espadachin.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testEspadachinSeMueveParaArribaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 11);
		Espadachin espadachin = new Espadachin(tablero, posicion);
		espadachin.moverArribaIzquierda();
		Assert.assertEquals(espadachin.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testEspadachinSeMueveParaArribaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 11);
		Espadachin espadachin = new Espadachin(tablero, posicion);
		espadachin.moverArribaDerecha();
		Assert.assertEquals(espadachin.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testEspadachinSeMueveParaAbajoIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 9);
		Espadachin espadachin = new Espadachin(tablero, posicion);
		espadachin.moverAbajoIzquierda();
		Assert.assertEquals(espadachin.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testEspadachinSeMueveParaAbajoDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 9);
		Espadachin espadachin = new Espadachin(tablero, posicion);
		espadachin.moverAbajoDerecha();
		Assert.assertEquals(espadachin.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test(expected = DestinoFueraDelMapaException.class)
	public void testEspadachinNoPuedeSalirDelMapa() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(20, 20);
		Espadachin espadachin = new Espadachin(tablero, posicion);
		espadachin.moverArriba();
	}
	
	@Test(expected = UnidadYaSeMovioException.class)
	public void testEspadachinNoSeMueveMasDeUnaVezPorTurno() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Espadachin espadachin = new Espadachin(tablero, posicion);
		espadachin.moverArriba();
		espadachin.moverArriba();
	}
}
*/