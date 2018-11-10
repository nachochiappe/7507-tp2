package fiuba.algo3.algoempires.Model;

import junit.framework.Assert;
import org.junit.Test;

public class AlgoEmpiresTest {

	@Test
	public void crearTableroLoInicializaVacio(){
		AlgoEmpires algoEmpires = new AlgoEmpires();
		algoEmpires.inicializarTablero();
        Assert.assertEquals(algoEmpires.elMapaEstaVacio(), true);
	}
	
	@Test
	public void crearTableroConUnEdificioNoEstaVacio() {
		AlgoEmpires algoEmpires = new AlgoEmpires();
		algoEmpires.inicializarTablero();
		algoEmpires.agregarPlazaCentralInicial();
		Assert.assertEquals(algoEmpires.elMapaEstaVacio(), false);
	}
	
	@Test
	public void siSeAgregaUnJugadorFaltaElOtro() {
		AlgoEmpires algoEmpires = new AlgoEmpires();
		algoEmpires.agregarJugadorConNombre("Pepito");
		Assert.assertEquals(algoEmpires.totalDeJugadores(), 1);
	}
	
	@Test
	public void siSeAgreganDosJugadoresSePuedeEmpezarAJugar() {
		AlgoEmpires algoEmpires = new AlgoEmpires();
		algoEmpires.agregarJugadorConNombre("Pepito");
		algoEmpires.agregarJugadorConNombre("Cosme");
		Assert.assertEquals(algoEmpires.sePuedeEmpezarAJugar(), true);
	}
}
