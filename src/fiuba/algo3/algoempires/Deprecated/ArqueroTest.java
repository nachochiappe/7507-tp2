package fiuba.algo3.algoempires.Deprecated;
/*
import static org.junit.Assert.*;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import fiuba.algo3.algoempires.Model.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Test;

public class ArqueroTest {

	@Test
	public void testArqueroSeMueveParaArribaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(10, 11);
		Arquero arquero = new Arquero(tablero, posicion);
		arquero.moverArriba();
		Assert.assertEquals(arquero.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArqueroSeMueveParaAbajoUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(10, 9);
		Arquero arquero = new Arquero(tablero, posicion);
		arquero.moverAbajo();
		Assert.assertEquals(arquero.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArqueroSeMueveParaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 10);
		Arquero arquero = new Arquero(tablero, posicion);
		arquero.moverIzquierda();
		Assert.assertEquals(arquero.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArqueroSeMueveParaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 10);
		Arquero arquero = new Arquero(tablero, posicion);
		arquero.moverDerecha();
		Assert.assertEquals(arquero.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArqueroSeMueveParaArribaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 11);
		Arquero arquero = new Arquero(tablero, posicion);
		arquero.moverArribaIzquierda();
		Assert.assertEquals(arquero.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArqueroSeMueveParaArribaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 11);
		Arquero arquero = new Arquero(tablero, posicion);
		arquero.moverArribaDerecha();
		Assert.assertEquals(arquero.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArqueroSeMueveParaAbajoIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(9, 9);
		Arquero arquero = new Arquero(tablero, posicion);
		arquero.moverAbajoIzquierda();
		Assert.assertEquals(arquero.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test
	public void testArqueroSeMueveParaAbajoDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Posicion posicion_nueva = new Posicion(11, 9);
		Arquero arquero = new Arquero(tablero, posicion);
		arquero.moverAbajoDerecha();
		Assert.assertEquals(arquero.posicion.getPosicionY(), posicion_nueva.getPosicionY());
	}
	
	@Test(expected = DestinoFueraDelMapaException.class)
	public void testArqueroNoPuedeSalirDelMapa() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(20, 20);
		Arquero arquero = new Arquero(tablero, posicion);
		arquero.moverArriba();
	}
	
	@Test(expected = UnidadYaSeMovioException.class)
	public void testArqueroNoSeMueveMasDeUnaVezPorTurno() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(10, 10);
		Arquero arquero = new Arquero(tablero, posicion);
		arquero.moverArriba();
		arquero.moverArriba();
	}
}
*/