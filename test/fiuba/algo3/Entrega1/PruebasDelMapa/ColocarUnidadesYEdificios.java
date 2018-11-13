package fiuba.algo3.Entrega1.PruebasDelMapa;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoempires.Model.Jugador.Jugador;

public class ColocarUnidadesYEdificios {
	
	@Test
	public void testPuedoColocarCastilloEnTablero() throws FueraDelMapaException {
		Tablero tablero = new Tablero();
		Castillo castillo = new Castillo(tablero);
		Posicion posicionDeInicio = new Posicion(0, 0);
		Posicion posicionDeFin = new Posicion(15, 15);
		tablero.poner(castillo, posicionDeInicio, posicionDeFin);
		Assert.assertEquals(castillo, tablero.obtenerPosicionable(0, 0));
		Assert.assertEquals(castillo, tablero.obtenerPosicionable(0, 15));
		Assert.assertEquals(castillo, tablero.obtenerPosicionable(15, 0));
		Assert.assertEquals(castillo, tablero.obtenerPosicionable(15, 15));
	}
	
	@Test
	public void testPuedoColocarPlazaCentralEnTablero() throws FueraDelMapaException {
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
	public void testPuedoColocarCuartelEnTablero() throws FueraDelMapaException {
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

	@Test(expected = FueraDelMapaException.class)
	public void testNoPuedoColocarPlazaCentralFueraDeTablero() throws FueraDelMapaException {
		Tablero tablero = new Tablero();
		PlazaCentral plaza = new PlazaCentral(tablero);
		Posicion posicionDeInicio = new Posicion(25, 25);
		Posicion posicionDeFin = new Posicion(26, 26);
		tablero.poner(plaza, posicionDeInicio, posicionDeFin);
	}
	
	@Test(expected = FueraDelMapaException.class)
	public void testNoPuedoColocarCuartelFueraDeTablero() throws FueraDelMapaException {
		Tablero tablero = new Tablero();
		Cuartel cuartel = new Cuartel(tablero);
		Posicion posicionDeInicio = new Posicion(25, 25);
		Posicion posicionDeFin = new Posicion(26, 26);
		tablero.poner(cuartel, posicionDeInicio, posicionDeFin);
	}

	@Test(expected = FueraDelMapaException.class)
	public void testConstruirPlazaCentralEnBordeLevantaError() throws FueraDelMapaException{
		Tablero tablero = new Tablero();
		Posicion posicion = new Posicion(19,19);
		PlazaCentral plaza = new PlazaCentral(tablero);
		plaza.construiteEn(posicion);
	}
	
	@Test
	public void testPuedoColocarAldeanoEnTablero() throws FueraDelMapaException {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("JugadorTest", tablero);
		Posicion posicion = new Posicion(10, 10);
		Aldeano aldeano = new Aldeano(tablero, jugador, posicion);
		tablero.poner(aldeano, posicion, posicion);
		Assert.assertEquals(aldeano, tablero.obtenerPosicionable(10, 10));
	}
	
	@Test
	public void testPuedoColocarArqueroEnTablero() throws FueraDelMapaException {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("JugadorTest", tablero);
		Posicion posicion = new Posicion(10, 10);
		Arquero arquero = new Arquero(tablero, jugador, posicion);
		tablero.poner(arquero, posicion, posicion);
		Assert.assertEquals(arquero, tablero.obtenerPosicionable(10, 10));
	}
	
	@Test
	public void testPuedoColocarEspadachinEnTablero() throws FueraDelMapaException {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("JugadorTest", tablero);
		Posicion posicion = new Posicion(10, 10);
		Espadachin espadachin = new Espadachin(tablero, jugador, posicion);
		tablero.poner(espadachin, posicion, posicion);
		Assert.assertEquals(espadachin, tablero.obtenerPosicionable(10, 10));
	}
	
	@Test
	public void testPuedoColocarArmaDeAsedioEnTablero() throws FueraDelMapaException {
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("JugadorTest", tablero);
		Posicion posicion = new Posicion(10, 10);
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, jugador, posicion);
		tablero.poner(armaDeAsedio, posicion, posicion);
		Assert.assertEquals(armaDeAsedio, tablero.obtenerPosicionable(10, 10));
	}
}
