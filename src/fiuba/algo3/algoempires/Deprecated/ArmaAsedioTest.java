package fiuba.algo3.algoempires.Deprecated;
/*
import static org.junit.Assert.*;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import fiuba.algo3.algoempires.Model.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Test;

public class ArmaAsedioTest {

	@Test
	public void testArmaAsedioSeMueveParaArribaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(10, 11);
		ArmaAsedio armaAsedio = new ArmaAsedio(tablero, posicion);
		armaAsedio.moverArriba();
		Assert.assertEquals(armaAsedio.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArmaAsedioSeMueveParaAbajoUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(10, 9);
		ArmaAsedio armaAsedio = new ArmaAsedio(tablero, posicion);
		armaAsedio.moverAbajo();
		Assert.assertEquals(armaAsedio.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArmaAsedioSeMueveParaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 10);
		ArmaAsedio armaAsedio = new ArmaAsedio(tablero, posicion);
		armaAsedio.moverIzquierda();
		Assert.assertEquals(armaAsedio.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArmaAsedioSeMueveParaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 10);
		ArmaAsedio armaAsedio = new ArmaAsedio(tablero, posicion);
		armaAsedio.moverDerecha();
		Assert.assertEquals(armaAsedio.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArmaAsedioSeMueveParaArribaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 11);
		ArmaAsedio armaAsedio = new ArmaAsedio(tablero, posicion);
		armaAsedio.moverArribaIzquierda();
		Assert.assertEquals(armaAsedio.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArmaAsedioSeMueveParaArribaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 11);
		ArmaAsedio armaAsedio = new ArmaAsedio(tablero, posicion);
		armaAsedio.moverArribaDerecha();
		Assert.assertEquals(armaAsedio.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArmaAsedioSeMueveParaAbajoIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 9);
		ArmaAsedio armaAsedio = new ArmaAsedio(tablero, posicion);
		armaAsedio.moverAbajoIzquierda();
		Assert.assertEquals(armaAsedio.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArmaAsedioSeMueveParaAbajoDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 9);
		ArmaAsedio armaAsedio = new ArmaAsedio(tablero, posicion);
		armaAsedio.moverAbajoDerecha();
		Assert.assertEquals(armaAsedio.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test(expected = DestinoFueraDelMapaException.class)
	public void testArmaAsedioNoPuedeSalirDelMapa() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(20, 20);
		ArmaAsedio armaAsedio = new ArmaAsedio(tablero, posicion);
		armaAsedio.moverArriba();
	}
	
	@Test(expected = UnidadYaSeMovioException.class)
	public void testArmaAsedioNoSeMueveMasDeUnaVezPorTurno() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		ArmaAsedio armaAsedio = new ArmaAsedio(tablero, posicion);
		armaAsedio.moverArriba();
		armaAsedio.moverArriba();
	}
}
*/