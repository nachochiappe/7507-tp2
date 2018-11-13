package fiuba.algo3.Entrega1.PruebasDelMapa;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;

public class ColocarUnidadesYEdificios {
	@Test
	public void testPuedoColocarPlazaCentralEnTablero() throws ConstruccionFueraDelMapaException {
		Tablero tablero = new Tablero();
		PlazaCentral plaza = new PlazaCentral(tablero);
		Posicion posicionDeInicio = new Posicion(10, 10);
		Posicion posicionDeFin = new Posicion(11, 11);
		tablero.poner(plaza, posicionDeInicio, posicionDeFin);
		Assert.assertEquals(plaza, tablero.obtenerPosicionable(10, 10));
		Assert.assertEquals(plaza, tablero.obtenerPosicionable(10, 11));
		Assert.assertEquals(plaza, tablero.obtenerPosicionable(11, 10));
		Assert.assertEquals(plaza, tablero.obtenerPosicionable(11, 11));
	}
	@Test
	public void testPuedoColocarCuartelEnTablero() throws ConstruccionFueraDelMapaException {
		Tablero tablero = new Tablero();
		Cuartel cuartel = new Cuartel(tablero);
		Posicion posicionDeInicio = new Posicion(10, 10);
		Posicion posicionDeFin = new Posicion(11, 11);
		tablero.poner(cuartel, posicionDeInicio, posicionDeFin);
		Assert.assertEquals(cuartel, tablero.obtenerPosicionable(10, 10));
		Assert.assertEquals(cuartel, tablero.obtenerPosicionable(10, 11));
		Assert.assertEquals(cuartel, tablero.obtenerPosicionable(11, 10));
		Assert.assertEquals(cuartel, tablero.obtenerPosicionable(11, 11));
	}

	@Test(expected = ConstruccionFueraDelMapaException.class)
	public void testNoPuedoColocarPlazaCentralFueraDeTablero() throws ConstruccionFueraDelMapaException {
		Tablero tablero = new Tablero();
		PlazaCentral plaza = new PlazaCentral(tablero);
		Posicion posicionDeInicio = new Posicion(25, 25);
		Posicion posicionDeFin = new Posicion(26, 26);
		tablero.poner(plaza, posicionDeInicio, posicionDeFin);
	}
	
	@Test(expected = ConstruccionFueraDelMapaException.class)
	public void testNoPuedoColocarCuartelFueraDeTablero() throws ConstruccionFueraDelMapaException {
		Tablero tablero = new Tablero();
		Cuartel cuartel = new Cuartel(tablero);
		Posicion posicionDeInicio = new Posicion(25, 25);
		Posicion posicionDeFin = new Posicion(26, 26);
		tablero.poner(cuartel, posicionDeInicio, posicionDeFin);
	}

	@Test(expected = ConstruccionFueraDelMapaException.class)
	public void testConstruirPlazaCentralEnBordeLevantaError() throws ConstruccionFueraDelMapaException{
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(19,19);
		PlazaCentral plaza = new PlazaCentral(tablero);
		plaza.construiteEn(posicion);
	}
}
