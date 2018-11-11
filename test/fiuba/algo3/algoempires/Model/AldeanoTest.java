package fiuba.algo3.algoempires.Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AldeanoTest {

	@Test
	public void testAldeanoSeMueveParaArribaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(10, 11);
		Aldeano aldeano = new Aldeano(tablero, posicion);
		aldeano.moverArriba();
		assertEquals(aldeano.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testAldeanoSeMueveParaAbajoUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(10, 9);
		Aldeano aldeano = new Aldeano(tablero, posicion);
		aldeano.moverAbajo();
		assertEquals(aldeano.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testAldeanoSeMueveParaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 10);
		Aldeano aldeano = new Aldeano(tablero, posicion);
		aldeano.moverIzquierda();
		assertEquals(aldeano.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testAldeanoSeMueveParaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 10);
		Aldeano aldeano = new Aldeano(tablero, posicion);
		aldeano.moverDerecha();
		assertEquals(aldeano.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testAldeanoSeMueveParaArribaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 11);
		Aldeano aldeano = new Aldeano(tablero, posicion);
		aldeano.moverArribaIzquierda();
		assertEquals(aldeano.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testAldeanoSeMueveParaArribaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 11);
		Aldeano aldeano = new Aldeano(tablero, posicion);
		aldeano.moverArribaDerecha();
		assertEquals(aldeano.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testAldeanoSeMueveParaAbajoIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 9);
		Aldeano aldeano = new Aldeano(tablero, posicion);
		aldeano.moverAbajoIzquierda();
		assertEquals(aldeano.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testAldeanoSeMueveParaAbajoDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 9);
		Aldeano aldeano = new Aldeano(tablero, posicion);
		aldeano.moverAbajoDerecha();
		assertEquals(aldeano.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test(expected = DestinoFueraDelMapaException.class)
	public void testAldeanoNoPuedeSalirDelMapa() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(20, 20);
		Aldeano aldeano = new Aldeano(tablero, posicion);
		aldeano.moverArriba();
	}
	
	@Test(expected = UnidadYaSeMovioException.class)
	public void testAldeanoNoSeMueveMasDeUnaVezPorTurno() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Aldeano aldeano = new Aldeano(tablero, posicion);
		aldeano.moverArriba();
		aldeano.moverArriba();
	}
}
