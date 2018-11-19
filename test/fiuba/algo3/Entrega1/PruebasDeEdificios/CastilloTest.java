package fiuba.algo3.Entrega1.PruebasDeEdificios;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class CastilloTest {
    @Test
    public void testCastilloCreaArmaDeAsedio() throws FueraDelMapaException {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        Castillo castillo = new Castillo(tablero);
        Posicion posicion = new Posicion();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, jugador, posicion);
        castillo.crearUnidad(armaDeAsedio);
        Assert.assertEquals(tablero.obtenerPosicionable(posicion.getPosicionX(), posicion.getPosicionY()), armaDeAsedio);
    }
}