package fiuba.algo3.Entrega1.PruebasDeUnidades;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

//import fiuba.algo3.algoempires.Model.AlgoEmpires;
//import fiuba.algo3.algoempires.Model.Excepciones.SoloPuedeRealizarAccionesEnSuTurnoException;

public class PruebasDeConstruccion {
	
    @Test
    public void testAldeanoPuedeConstruirCuartel() throws FueraDelMapaException, AldeanoOcupadoException, SoloSePermiteUnAldeanoException {
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        Cuartel cuartel = new Cuartel(jugador);
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(cuartel, posicion);
        Assert.assertTrue(cuartel.obtenerPosicionInicial().dentroDe(10,10));
        Assert.assertTrue(cuartel.obtenerPosicionFinal().dentroDe(11,11));
    }
    
    @Test
    public void testAldeanoPuedeConstruirPlazaCentral() throws FueraDelMapaException, AldeanoOcupadoException, SoloSePermiteUnAldeanoException {
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        Assert.assertTrue(plazaCentral.obtenerPosicionInicial().dentroDe(10,10));
        Assert.assertTrue(plazaCentral.obtenerPosicionFinal().dentroDe(11,11));
    }
    
    /*
    @Test(expected = SoloPuedeRealizarAccionesEnSuTurnoException.class)
    public void testAldeanoPuedeConstruirUnicamenteEnSuTurno() throws  SoloPuedeRealizarAccionesEnSuTurnoException{
    	AlgoEmpires juego = new AlgoEmpires();
    	Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        JugadorHUD jugador = new JugadorHUD("Jugador1", tablero);
        JugadorHUD jugador2 = new JugadorHUD("Jugador2", tablero);
        juego.setTurnoActual(jugador);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral(tablero);
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        juego.setTurnoActual(jugador2);
        Cuartel cuartel = new Cuartel(tablero);
        Posicion posicion2 = new Posicion(0,0);
        aldeano.construir(cuartel, posicion2);
    }
    */
    
    @Test
    public void testAldeanoNoSumaOroMientrasConstruye() throws FueraDelMapaException, AldeanoOcupadoException, SoloSePermiteUnAldeanoException, CantidadJugadoresIncorrectaException, JugadorYaExisteException {
    	AlgoEmpires juego = new AlgoEmpires();
    	juego.agregarJugador("Jugador1");
    	juego.agregarJugador("Jugador2");
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        juego.empezarJuego();
        Jugador jugador = juego.getJugadorActual();
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        juego.pasarTurno();
        juego.pasarTurno();
        Assert.assertEquals(200, jugador.getOro());
    }

    public void testAldeanoSoloPuedeConstruirUnEdificioALaVez() throws FueraDelMapaException, AldeanoOcupadoException, SoloSePermiteUnAldeanoException {
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        Cuartel cuartel = new Cuartel(jugador);
        Posicion posicion2 = new Posicion(0,0);
        aldeano.construir(cuartel, posicion2);
    }
}
