package fiuba.algo3.Entrega1.PruebasDeUnidades;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoOcupadoException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
/*
public class PruebasDeReparacion {
        
	@Test
    public void testAldeanoPuedeRepararCastillo() {
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        Castillo castillo = new Castillo();
        castillo.vida = 985;
        aldeano.reparar(castillo);
        Assert.assertEquals(1000, castillo.getVida());
    }
	
	@Test
    public void testAldeanoPuedeRepararPlazaCentral() throws FueraDelMapaException{
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        plazaCentral.vida = 425;
        aldeano.reparar(plazaCentral);
        Assert.assertEquals(450, plazaCentral.getVida());
    }
	
	@Test
    public void testAldeanoPuedeRepararCuartel() throws FueraDelMapaException, AldeanoOcupadoException, SoloSePermiteUnAldeanoException {
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        Cuartel cuartel = new Cuartel();
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

	
	@Test(expected = .class)
    public void testAldeanoSoloPuedeRepararUnEdificioALaVez() throws  FueraDelMapaException{
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        Aldeano aldeano2 = (Aldeano) lista_unidades.get(1);
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        Cuartel cuartel = new Cuartel();
        Posicion posicion2 = new Posicion(0,0);
        aldeano2.construir(cuartel, posicion2);
        plazaCentral.vida = 400;
        cuartel.vida = 200;
        aldeano.reparar(plazaCentral);
        aldeano.reparar(cuartel);
    }
	
	@Test
    public void testAldeanoNoSumaOroMientrasRepara() throws  FueraDelMapaException{
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion posicion = new Posicion(10,10);
        aldeano.sumarOro();
        aldeano.construir(plazaCentral, posicion);
        plazaCentral.vida = 400;
        aldeano.reparar(plazaCentral);
        aldeano.sumarOro();
        Assert.assertEquals(120, jugador.getOro());
    }
	
	@Test
    public void testAldeanoVuelveASumarOroDespuesDeReparar() throws  FueraDelMapaException{
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion posicion = new Posicion(10,10);
        aldeano.sumarOro();
        aldeano.construir(plazaCentral, posicion);
        plazaCentral.vida = 425;
        aldeano.reparar(plazaCentral);
        aldeano.habilitarReparacion();
        aldeano.sumarOro();
        Assert.assertEquals(140, jugador.getOro());
    }
}*/

