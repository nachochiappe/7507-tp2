package fiuba.algo3.Entrega1.PruebasDeUnidades;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaConstruyendoException;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaReparandoException;
import fiuba.algo3.algoempires.Model.Excepciones.ConstruccionFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class PruebasDeReparacion {
        
	@Test
    public void testAldeanoPuedeRepararCastillo() throws AldeanoYaEstaReparandoException{
		Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        Castillo castillo = new Castillo();
        castillo.vida = 985;
        aldeano.reparar(castillo);
        Assert.assertEquals(1000, castillo.getVida());
    }
	
	@Test
    public void testAldeanoPuedeRepararPlazaCentral() throws AldeanoYaEstaConstruyendoException, AldeanoYaEstaReparandoException, ConstruccionFueraDelMapaException{
		Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral(tablero);
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        plazaCentral.vida = 425;
        aldeano.reparar(plazaCentral);
        Assert.assertEquals(450, plazaCentral.getVida());
    }
	
	@Test
    public void testAldeanoPuedeRepararCuartel() throws AldeanoYaEstaConstruyendoException, AldeanoYaEstaReparandoException, ConstruccionFueraDelMapaException{
		Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        Cuartel cuartel = new Cuartel(tablero);
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(cuartel, posicion);
        cuartel.vida = 200;
        aldeano.reparar(cuartel);
        Assert.assertEquals(250, cuartel.getVida());
    }
	
	/*
	@Test
    public void testAldeanoPuedeRepararUnicamenteEnSuTurno(){
        boolean trueish = true;
        Assert.assertEquals(trueish, true);
    }
    */
	
	@Test(expected = AldeanoYaEstaReparandoException.class)
    public void testAldeanoSoloPuedeRepararUnEdificioALaVez() throws AldeanoYaEstaConstruyendoException, AldeanoYaEstaReparandoException, ConstruccionFueraDelMapaException{
		Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        Aldeano aldeano2 = (Aldeano) lista_unidades.get(1);
        PlazaCentral plazaCentral = new PlazaCentral(tablero);
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        Cuartel cuartel = new Cuartel(tablero);
        Posicion posicion2 = new Posicion(0,0);
        aldeano2.construir(cuartel, posicion2);
        plazaCentral.vida = 400;
        cuartel.vida = 200;
        aldeano.reparar(plazaCentral);
        aldeano.reparar(cuartel);
    }
	
	@Test
    public void testAldeanoNoSumaOroMientrasRepara() throws AldeanoYaEstaConstruyendoException, AldeanoYaEstaReparandoException, ConstruccionFueraDelMapaException{
		Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral(tablero);
        Posicion posicion = new Posicion(10,10);
        aldeano.sumarOro();
        aldeano.construir(plazaCentral, posicion);
        plazaCentral.vida = 400;
        aldeano.reparar(plazaCentral);
        aldeano.sumarOro();
        Assert.assertEquals(120, jugador.getOro());
    }
	
	@Test
    public void testAldeanoVuelveASumarOroDespuesDeReparar() throws AldeanoYaEstaConstruyendoException, AldeanoYaEstaReparandoException, ConstruccionFueraDelMapaException{
		Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral(tablero);
        Posicion posicion = new Posicion(10,10);
        aldeano.sumarOro();
        aldeano.construir(plazaCentral, posicion);
        plazaCentral.vida = 425;
        aldeano.reparar(plazaCentral);
        aldeano.habilitarReparacion();
        aldeano.sumarOro();
        Assert.assertEquals(140, jugador.getOro());
    }
}
