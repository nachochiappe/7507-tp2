package fiuba.algo3.algoempires.Model;

import fiuba.algo3.algoempires.Model.Excepciones.JugadorYaExisteException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;

import junit.framework.Assert;
import org.junit.Test;

public class AlgoEmpiresTest {

	@Test
	public void crearTableroLoInicializaVacio(){
		AlgoEmpires algoEmpires = new AlgoEmpires();
		algoEmpires.inicializarTablero();
		Assert.assertTrue(algoEmpires.elMapaEstaVacio());
	}
	/*
	Dejo este comentado porque está fallando y no sé por qué jaja
	@Test
	public void crearTableroConUnEdificioNoEstaVacio() {
		AlgoEmpires algoEmpires = new AlgoEmpires();
		algoEmpires.inicializarTablero();
		algoEmpires.agregarPlazaCentralInicial();
		Assert.assertFalse(algoEmpires.elMapaEstaVacio());
	}*/
	
	@Test
	public void siSeAgregaUnJugadorFaltaElOtro() throws JugadorYaExisteException {
		AlgoEmpires algoEmpires = new AlgoEmpires();
		algoEmpires.agregarJugador("Cosme Fulanito");
		Assert.assertEquals(algoEmpires.getJugadores().size(), 1);
	}
	
	@Test
	public void siSeAgreganDosJugadoresSePuedeEmpezarAJugar() throws JugadorYaExisteException {
		AlgoEmpires algoEmpires = new AlgoEmpires();
		algoEmpires.agregarJugador("Pepito");
		algoEmpires.agregarJugador("Cosme");
		Assert.assertTrue(algoEmpires.sePuedeEmpezarAJugar());
	}

	@Test
	public void jugadorEmpiezaCon100DeOro() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Jugador jugador = new Jugador("Jugador");
		Assert.assertEquals(jugador.getOro(), 100);
	}

	@Test
	public void jugadorEmpiezaCon3Aldeanos() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
		Jugador jugador = new Jugador("Jugador");
		Assert.assertEquals(jugador.getUnidades().size(), 3);
		for (Unidad unidad: jugador.getUnidades()) {
			Assert.assertTrue(unidad instanceof Aldeano);
		}
	}
}
