package fiuba.algo3.Entrega1.PruebasDeEdificios;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class CuartelTest {
    @Test
    public void testCuartelCreaEspadachin() throws FueraDelMapaException{
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        Cuartel cuartel = new Cuartel(tablero);
        Posicion posicion = new Posicion();
        Espadachin espadachin = new Espadachin(tablero, jugador, posicion);
        cuartel.crearUnidad(espadachin);
        Assert.assertEquals(tablero.obtenerPosicionable(posicion.getPosicionX(), posicion.getPosicionY()), espadachin);
    }
    
    @Test
    public void testCuartelCreaArquero() throws FueraDelMapaException{
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        Cuartel cuartel = new Cuartel(tablero);
        Posicion posicion = new Posicion();
        Arquero arquero = new Arquero(tablero, jugador, posicion);
        cuartel.crearUnidad(arquero);
        Assert.assertEquals(tablero.obtenerPosicionable(posicion.getPosicionX(), posicion.getPosicionY()), arquero);
    }
}
