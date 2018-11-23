package pruebas;

import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Excepciones.CantidadJugadoresIncorrectaException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Turnos {
    @Test
    public void aldeanoSumaOro() throws CantidadJugadoresIncorrectaException {
        AlgoEmpires algoEmpires = new AlgoEmpires();
        algoEmpires.agregarJugador("jugador1");
        algoEmpires.agregarJugador("jugador2");
        algoEmpires.empezarJuego();
        Jugador jugador = algoEmpires.getJugadorActual();
        Assert.assertEquals(jugador.getOro(), 100);
        algoEmpires.pasarTurno();
        algoEmpires.pasarTurno();
        Assert.assertEquals(jugador.getOro(), 160);

    }
}
