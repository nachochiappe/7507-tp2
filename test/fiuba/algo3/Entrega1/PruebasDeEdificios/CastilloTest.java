package fiuba.algo3.Entrega1.PruebasDeEdificios;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import java.util.ArrayList;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;

public class CastilloTest {
    @Test
    public void testCastilloCreaArmaDeAsedio()  { Tablero tablero = new Tablero();
        Jugador jugador=new Jugador("jugadorTest",tablero);
        Castillo castillo= new Castillo(tablero);
        Posicion posicion =  new Posicion(18,18);
        ArmaDeAsedio arma=castillo.crearArmaDeAsedio(tablero,jugador,posicion);
        Assert.assertEquals(arma.getClass(),ArmaDeAsedio.class);
    }

    @Test

    public void testCastilloCreaArmaDeAsedioSumaUnaUnidadAlJugador(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("JugadorTest", tablero);
        Castillo castillo = new Castillo(tablero);
        Posicion posicion =  new Posicion(18,18);
        ArmaDeAsedio arma=castillo.crearArmaDeAsedio(tablero,jugador,posicion);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Assert.assertEquals(lista_unidades.size(),4);
    }
}