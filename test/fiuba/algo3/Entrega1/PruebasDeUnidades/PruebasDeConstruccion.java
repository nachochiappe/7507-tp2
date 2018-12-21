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

public class PruebasDeConstruccion {
	
    @Test
    public void testAldeanoPuedeConstruirCuartel() throws FueraDelMapaException, AldeanoOcupadoException, SoloSePermiteUnAldeanoException, OroInsuficienteException, PosicionOcupadaException {
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        Cuartel cuartel = new Cuartel();
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(cuartel, posicion);
        Assert.assertTrue(cuartel.obtenerPosicionInicial().dentroDe(10,10));
        Assert.assertTrue(cuartel.obtenerPosicionFinal().dentroDe(11,11));
    }
    
    @Test
    public void testAldeanoPuedeConstruirPlazaCentral() throws FueraDelMapaException, AldeanoOcupadoException, SoloSePermiteUnAldeanoException, OroInsuficienteException, PosicionOcupadaException {
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
    
    
    @Test(expected = AldeanoOcupadoException.class)
    public void testAldeanoPuedeConstruirUnicamenteEnSuTurno() throws  SoloPuedeRealizarAccionesEnSuTurnoException, AldeanoOcupadoException, FueraDelMapaException, SoloSePermiteUnAldeanoException, OroInsuficienteException, PosicionOcupadaException{
    	AlgoEmpires juego = new AlgoEmpires();
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("Jugador1");
        Jugador jugador2 = new Jugador("Jugador2");
        juego.setTurnoActual(jugador);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral();
        plazaCentral.establecerJugador(jugador);
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        juego.setTurnoActual(jugador2);
        Cuartel cuartel = new Cuartel();
        cuartel.establecerJugador(jugador);
        Posicion posicion2 = new Posicion(0,0);
        aldeano.construir(cuartel, posicion2);
    }
    
    
    @Test
    public void testAldeanoNoSumaOroMientrasConstruye() throws FueraDelMapaException, AldeanoOcupadoException, SoloSePermiteUnAldeanoException, CantidadJugadoresIncorrectaException, JugadorYaExisteException, OroInsuficienteException, PosicionOcupadaException {
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
        Assert.assertEquals(100, jugador.getOro());
    }

    public void testAldeanoSoloPuedeConstruirUnEdificioALaVez() throws FueraDelMapaException, AldeanoOcupadoException, SoloSePermiteUnAldeanoException, OroInsuficienteException, PosicionOcupadaException {
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicion posicion = new Posicion(10,10);
        aldeano.construir(plazaCentral, posicion);
        Cuartel cuartel = new Cuartel();
        Posicion posicion2 = new Posicion(0,0);
        aldeano.construir(cuartel, posicion2);
    }
}
