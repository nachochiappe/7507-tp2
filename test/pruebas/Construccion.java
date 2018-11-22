package pruebas;

import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Construccion {
    @Test
    public void aldeanoSumaOro() {
        AlgoEmpires algoEmpires = new AlgoEmpires();
        Jugador jugador = new Jugador("jugador1");
        Jugador jugador2 = new Jugador("jugador2");
        algoEmpires.setTurnoActual(jugador);
        Assert.assertEquals(jugador.getOro(), 100);

    }
}
