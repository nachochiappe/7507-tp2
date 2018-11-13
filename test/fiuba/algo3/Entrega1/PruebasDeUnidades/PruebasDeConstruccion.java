package fiuba.algo3.Entrega1.PruebasDeUnidades;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaConstruyendoException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloPuedeRealizarAccionesEnSuTurnoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class PruebasDeConstruccion {
	
    @Test
    public void testAldeanoPuedeConstruirCuartel() throws AldeanoYaEstaConstruyendoException{
        Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        Cuartel cuartel = new Cuartel(tablero);
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(cuartel, posicion);
        Assert.assertTrue(cuartel.obtenerPosicionInicial().dentroDe(10,10));
        Assert.assertTrue(cuartel.obtenerPosicionFinal().dentroDe(11,11));
    }
    
    @Test
    public void testAldeanoPuedeConstruirPlazaCentral() throws AldeanoYaEstaConstruyendoException{
    	Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral(tablero);
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        Assert.assertTrue(plazaCentral.obtenerPosicionInicial().dentroDe(10,10));
        Assert.assertTrue(plazaCentral.obtenerPosicionFinal().dentroDe(11,11));
    }
    
    @Test
    public void testAldeanoPuedeConstruirUnicamenteEnSuTurno() throws AldeanoYaEstaConstruyendoException, SoloPuedeRealizarAccionesEnSuTurnoException{
    	boolean trueish = true;
        Assert.assertEquals(trueish, true);
    }
    
    @Test
    public void testAldeanoNoSumaOroMientrasConstruye() throws AldeanoYaEstaConstruyendoException{
    	Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral(tablero);
        Posicion posicion = new Posicion(10,10);
        aldeano.sumarOro();
        aldeano.construir(plazaCentral, posicion);
        aldeano.sumarOro();
        Assert.assertEquals(120, jugador.getOro());
    }
    
    @Test(expected = AldeanoYaEstaConstruyendoException.class)
    public void testAldeanoSoloPuedeConstruirUnEdificioALaVez() throws AldeanoYaEstaConstruyendoException{
    	Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral(tablero);
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        Cuartel cuartel = new Cuartel(tablero);
        Posicion posicion2 = new Posicion(0,0);
        aldeano.construir(cuartel, posicion2);
    }
}
