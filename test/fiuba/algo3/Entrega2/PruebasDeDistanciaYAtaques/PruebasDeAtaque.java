package fiuba.algo3.Entrega2.PruebasDeDistanciaYAtaques;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class PruebasDeAtaque {


	@Test
    public void testEspadachinAtacaPlazaCentralYLeBajaVida() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException{
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = new Posicion(3,3);
		PlazaCentral plaza = new PlazaCentral();
		try {
			plaza.construiteEn(new Aldeano(jugador, pos), pos);
		} catch (FueraDelMapaException | SoloSePermiteUnAldeanoException e) {
			System.out.println("Error al construir la plaza de prueba");
		}
		Espadachin espadachin = new Espadachin(jugador, pos);
		espadachin.atacar(plaza);
		Assert.assertEquals(plaza.obtenerVida(), 35);
	}
	
	@Test
    public void testEspadachinAtacaAOtroEspadachinYLeBajaVida() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = new Posicion(4,4);
		Espadachin espadachin = new Espadachin(jugador, pos);
		Espadachin espadachinMalo = new Espadachin(jugador, pos);
		espadachin.atacar(espadachinMalo);
		Assert.assertEquals(espadachinMalo.getHp(), 75);
	}

	@Test(expected = ObjetivoFueraDeRangoException.class)
    public void testEspadachinAtacaAOtroEspadachinQueNoEstaCercaYLevantaExcepcion() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
		Jugador player1 = new Jugador("Pepito");
		Jugador player2 = new Jugador("Fulanito");
		Posicion pos1 = new Posicion(0,0);
		Posicion pos2 = new Posicion(0,3);
		Espadachin espadachinBueno = new Espadachin (player1, pos1);
		Espadachin espadachinMalo = new Espadachin (player2, pos2);
		espadachinBueno.atacar(espadachinMalo);
	}
	
	@Test(expected = ObjetivoFueraDeRangoException.class)
    public void testEspadachinAtacaACastilloQueNoEstaCercaYLevantaExcepcion() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
		Jugador player1 = new Jugador("Pepito");
		Jugador player2 = new Jugador("Fulanito");
		Posicion pos1 = new Posicion(0,0);
		Posicion pos2 = new Posicion(0,3);
		Espadachin espadachinBueno = new Espadachin (player1, pos1);
		Castillo castilloMalo = new Castillo();
		try {
			castilloMalo.construiteEn(new Aldeano(player1, pos2), pos2);
		} catch (FueraDelMapaException e) {
			System.out.println("Error al construir el castillo de prueba");
		} catch (SoloSePermiteUnAldeanoException e) {
			e.printStackTrace();
		}
		espadachinBueno.atacar(castilloMalo);
	}
	
	@Test
    public void testArqueroAtacaCuartelYLeBajaVida() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException{
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = new Posicion(4,4);
		Cuartel cuartel = new Cuartel();
		try {
			cuartel.construiteEn(new Aldeano(jugador, pos), pos);
		} catch (FueraDelMapaException e) {
			System.out.println("Error al construir el cuartel de prueba");
		} catch (SoloSePermiteUnAldeanoException e) {
			e.printStackTrace();
		}
		Arquero arquero = new Arquero(jugador, pos);
		arquero.atacar(cuartel);
		Assert.assertEquals(cuartel.obtenerVida(), 40);
	}
	
	@Test
    public void testArqueroAtacaAOtroArqueroYLeBajaVida() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = new Posicion(4,4);
		Arquero arquero = new Arquero(jugador, pos);
		Arquero arqueroMalo = new Arquero(jugador, pos);
		arquero.atacar(arqueroMalo);
		Assert.assertEquals(arqueroMalo.getHp(), 60);
	}
	@Test
    public void testArqueroAtacaAUnEspadachinYLeBajaVida() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = new Posicion(4,4);
		Arquero arquero = new Arquero(jugador, pos);
		Espadachin espadachinMalo = new Espadachin(jugador, pos);
		arquero.atacar(espadachinMalo);
		Assert.assertEquals(espadachinMalo.getHp(), 85);
	}
	
	@Test
    public void testEspadachinAtacaAUnArqueroYLeBajaVida() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion pos = new Posicion(4,4);
		Arquero arqueroMalo = new Arquero(jugador, pos);
		Espadachin espadachin = new Espadachin(jugador, pos);
		espadachin.atacar(arqueroMalo);
		Assert.assertEquals(arqueroMalo.getHp(), 50);
	}
	
	@Test
    public void testArmaDeAsedioMontadaAtacaCuartelYLeSacaVida() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException{
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion posicionArma = new Posicion(4,4);
		Posicion posicionCastillo = new Posicion(9,4);
		Castillo castilloMalo = new Castillo();
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugador, posicionArma);
		try {
			castilloMalo.construiteEn(new Aldeano(jugador, posicionArma), posicionCastillo);
		} catch (FueraDelMapaException e) {
			System.out.println("Error al construir el castillo de prueba");
		} catch (SoloSePermiteUnAldeanoException e) {
			e.printStackTrace();
		}
		armaDeAsedio.toggleMontar();
		armaDeAsedio.atacar(castilloMalo);
		Assert.assertTrue(castilloMalo.obtenerVida()<0);
	}

	@Test (expected = ArmaDeAsedioNoAtacaUnidadesException.class)
    public void testArmaDeAsedioMontadaAtacaArqueroYLevantaExcepcion() throws ArmaDeAsedioNoAtacaUnidadesException, ObjetivoFueraDeRangoException, ArmaDeAsedioNoMontadaException {
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion posicionArma = new Posicion(4,4);
		Posicion posicionArquero = new Posicion(9,4);
		Arquero arqueroMalo = new Arquero(jugador, posicionArquero);
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugador, posicionArma);
		armaDeAsedio.toggleMontar();
		armaDeAsedio.atacar(arqueroMalo);
	}
	
	@Test (expected = ArmaDeAsedioNoMontadaException.class)
    public void testArmaDeAsedioNoMontadaIntentaAtacarYLevantaExcepcion() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
		Jugador jugador = Mockito.mock(Jugador.class);
		Posicion posicionArma = new Posicion(4,4);
		Posicion posicionArquero = new Posicion(9,4);
		Arquero arqueroMalo = new Arquero(jugador, posicionArquero);
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugador, posicionArma);
		armaDeAsedio.atacar(arqueroMalo);
	}
	
	@Test
    public void testCastilloAtacaArqueroQueTieneEnRangoYLeBajaVida() throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
		Jugador player1 = new Jugador("Pepito");
		Jugador player2 = new Jugador("Fulanito");
		Posicion posEsp = new Posicion(0,0);
		Posicion posCastillo = new Posicion(0,3);
		Espadachin espadachinMalo = new Espadachin (player1, posEsp);
		Castillo castillo = new Castillo();
		try {
			castillo.construiteEn(new Aldeano(player1, posCastillo), posCastillo);
		} catch (FueraDelMapaException e) {
			System.out.println("Error al construir el castillo de prueba");
		} catch (SoloSePermiteUnAldeanoException e) {
			e.printStackTrace();
		}
		castillo.atacar(espadachinMalo);
		Assert.assertEquals(espadachinMalo.getHp(), 80);
	}
	
}
