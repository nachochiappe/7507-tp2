package fiuba.algo3.Entrega1.PruebasDeEdificios;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CuartelTest {
    @Test
    public void testCuartelCreaArqueroDevuelveArquero() {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        Cuartel cuartel= new Cuartel();
        Posicion posicion =  new Posicion(18,18);
        Arquero arquero = cuartel.crearArquero(jugador,posicion);
        Assert.assertEquals(arquero.getClass(),Arquero.class);
    }
    public void testCuartelCreaEspadachinDevuelveEspadachin() {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        Cuartel cuartel= new Cuartel();
        Posicion posicion =  new Posicion(18,18);
        Espadachin espadachin=cuartel.crearEspadachin(jugador,posicion);
        Assert.assertEquals(espadachin.getClass(),Espadachin.class);
    }
    @Test

    public void testCuartelCreaArqueroSumaUnaUnidadAlJugador(){
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        Cuartel cuartel= new Cuartel();
        Posicion posicion =  new Posicion(18,18);
        Arquero arquero=cuartel.crearArquero(jugador,posicion);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Assert.assertEquals(lista_unidades.size(),4);
    }
    @Test
    public void testCuartelCreaEspadachinSumaUnaUnidadAlJugador(){
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        Cuartel cuartel= new Cuartel();
        Posicion posicion =  new Posicion(18,18);
        Espadachin espadachin=cuartel.crearEspadachin(jugador,posicion);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Assert.assertEquals(lista_unidades.size(),4);
    }
}
