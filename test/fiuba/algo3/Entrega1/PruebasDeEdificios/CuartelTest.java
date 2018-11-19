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
import java.util.ArrayList;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;

public class CuartelTest {
    @Test
    public void testCuartelCreaArqueroDevuelveArquero() {
        Tablero tablero = new Tablero();
        Jugador jugador=new Jugador("jugadorTest",tablero);
        Cuartel cuartel= new Cuartel(tablero);
        Posicion posicion =  new Posicion(18,18);
        Arquero arquero=cuartel.crearArquero(tablero,jugador,posicion);
        Assert.assertEquals(arquero.getClass(),Arquero.class);
    }
    public void testCuartelCreaEspadachinDevuelveEspadachin() {
        Tablero tablero = new Tablero();
        Jugador jugador=new Jugador("jugadorTest",tablero);
        Cuartel cuartel= new Cuartel(tablero);
        Posicion posicion =  new Posicion(18,18);
        Espadachin espadachin=cuartel.crearEspadachin(tablero,jugador,posicion);
        Assert.assertEquals(espadachin.getClass(),Espadachin.class);
    }
    @Test

    public void testCuartelCreaArqueroSumaUnaUnidadAlJugador(){
        Tablero tablero = new Tablero();
        Jugador jugador=new Jugador("jugadorTest",tablero);
        Cuartel cuartel= new Cuartel(tablero);
        Posicion posicion =  new Posicion(18,18);
        Arquero arquero=cuartel.crearArquero(tablero,jugador,posicion);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Assert.assertEquals(lista_unidades.size(),4);
    }
    @Test
    public void testCuartelCreaEspadachinSumaUnaUnidadAlJugador(){
        Tablero tablero = new Tablero();
        Jugador jugador=new Jugador("jugadorTest",tablero);
        Cuartel cuartel= new Cuartel(tablero);
        Posicion posicion =  new Posicion(18,18);
        Espadachin espadachin=cuartel.crearEspadachin(tablero,jugador,posicion);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Assert.assertEquals(lista_unidades.size(),4);
    }
}
