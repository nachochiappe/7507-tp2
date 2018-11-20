package fiuba.algo3.Entrega1.PruebasDelMapa;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class ColocarUnidadesYEdificios {
	
	@Test
	public void testPuedoColocarCastilloEnTablero() throws FueraDelMapaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Castillo castillo = new Castillo();
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
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		PlazaCentral plaza = new PlazaCentral();
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
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Cuartel cuartel = new Cuartel();
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
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		PlazaCentral plaza = new PlazaCentral();
		Posicion posicionDeInicio = new Posicion(25, 25);
		Posicion posicionDeFin = new Posicion(26, 26);
		tablero.poner(plaza, posicionDeInicio, posicionDeFin);
	}
	
	@Test(expected = FueraDelMapaException.class)
	public void testNoPuedoColocarCuartelFueraDeTablero() throws FueraDelMapaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Cuartel cuartel = new Cuartel();
		Posicion posicionDeInicio = new Posicion(25, 25);
		Posicion posicionDeFin = new Posicion(26, 26);
		tablero.poner(cuartel, posicionDeInicio, posicionDeFin);
	}

	@Test(expected = FueraDelMapaException.class)
	public void testConstruirPlazaCentralEnBordeLevantaError() throws FueraDelMapaException{
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Posicion posicion = new Posicion(19,19);
		PlazaCentral plaza = new PlazaCentral();
		plaza.construiteEn(posicion);
	}
	
	@Test
	public void testPuedoColocarAldeanoEnTablero() throws FueraDelMapaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Jugador jugador = new Jugador("JugadorTest");
		Posicion posicion = new Posicion(10, 10);
		Aldeano aldeano = new Aldeano(jugador, posicion);
		tablero.poner(aldeano, posicion, posicion);
		Assert.assertEquals(aldeano, tablero.obtenerPosicionable(10, 10));
	}
	
	@Test
	public void testPuedoColocarArqueroEnTablero() throws FueraDelMapaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Jugador jugador = new Jugador("JugadorTest");
		Posicion posicion = new Posicion(10, 10);
		Arquero arquero = new Arquero(jugador, posicion);
		tablero.poner(arquero, posicion, posicion);
		Assert.assertEquals(arquero, tablero.obtenerPosicionable(10, 10));
	}
	
	@Test
	public void testPuedoColocarEspadachinEnTablero() throws FueraDelMapaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Jugador jugador = new Jugador("JugadorTest");
		Posicion posicion = new Posicion(10, 10);
		Espadachin espadachin = new Espadachin(jugador, posicion);
		tablero.poner(espadachin, posicion, posicion);
		Assert.assertEquals(espadachin, tablero.obtenerPosicionable(10, 10));
	}
	
	@Test
	public void testPuedoColocarArmaDeAsedioEnTablero() throws FueraDelMapaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Jugador jugador = new Jugador("JugadorTest");
		Posicion posicion = new Posicion(10, 10);
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugador, posicion);
		tablero.poner(armaDeAsedio, posicion, posicion);
		Assert.assertEquals(armaDeAsedio, tablero.obtenerPosicionable(10, 10));
	}
}
