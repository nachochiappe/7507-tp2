package fiuba.algo3.Entrega2.DistribucionDeJugadores;

import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class Turnos {
    @Test
    public void aldeanoSumaOro() throws CantidadJugadoresIncorrectaException, JugadorYaExisteException {
        AlgoEmpires algoEmpires = new AlgoEmpires();
        algoEmpires.agregarJugador("jugador1");
        algoEmpires.agregarJugador("jugador2");
        algoEmpires.empezarJuego();
        Jugador jugador = algoEmpires.getJugadorActual();
        Assert.assertEquals(jugador.getOro(), 160);
        algoEmpires.pasarTurno();
        algoEmpires.pasarTurno();
        Assert.assertEquals(jugador.getOro(), 220);
    }
    
    @Test
    public void aldeanoReparandoNoSumaOro() throws CantidadJugadoresIncorrectaException, AldeanoOcupadoException, SoloSePermiteUnAldeanoException, EdificioNoNecesitaRepararse, FueraDelMapaException, JugadorYaExisteException, OroInsuficienteException, PosicionOcupadaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
    	AlgoEmpires algoEmpires = new AlgoEmpires();
        algoEmpires.agregarJugador("jugador1");
        algoEmpires.agregarJugador("jugador2");
        algoEmpires.empezarJuego();
        Jugador jugador = algoEmpires.getJugadorActual();
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Aldeano aldeano = (Aldeano) lista_unidades.get(0);
        PlazaCentral plazaCentral = new PlazaCentral();
        //PRIMER TURNO DE CONSTRUCCION
        aldeano.construir(plazaCentral, new Posicion(10,10));
        Assert.assertEquals(jugador.getOro(), 60);
        algoEmpires.pasarTurno(); //TURNO JUGADORMALO
        Jugador jugadorMalo = algoEmpires.getJugadorActual();
        Espadachin espadachin = new Espadachin(jugadorMalo, new Posicion(9, 9));
        //SEGUNDO TURNO DE CONSTRUCCION
        algoEmpires.pasarTurno(); //TURNO JUGADOR
        algoEmpires.pasarTurno(); //TURNO JUGADORMALO
        //TERCER TURNO DE CONSTRUCCION
        algoEmpires.pasarTurno(); //TURNO JUGADOR
        algoEmpires.pasarTurno(); //TURNO JUGADORMALO
        algoEmpires.pasarTurno(); //TURNO JUGADOR
		plazaCentral.recibeDanioDe(espadachin);
        aldeano.reparar(plazaCentral);
        algoEmpires.pasarTurno(); //TURNO JUGADORMALO
        algoEmpires.pasarTurno(); //TURNO JUGADOR
        Assert.assertEquals(jugador.getOro(), 220);
    }
}
