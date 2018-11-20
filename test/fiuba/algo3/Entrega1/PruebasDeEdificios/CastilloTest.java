package fiuba.algo3.Entrega1.PruebasDeEdificios;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CastilloTest {
    @Test
    public void testCastilloCreaArmaDeAsedio()  {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador= new Jugador("jugadorTest");
        Castillo castillo= new Castillo();
        Posicion posicion = new Posicion(18,18);
        ArmaDeAsedio arma = castillo.crearArmaDeAsedio(jugador,posicion);
        Assert.assertEquals(arma.getClass(),ArmaDeAsedio.class);
    }

    @Test
    public void testCastilloCreaArmaDeAsedioSumaUnaUnidadAlJugador(){
        Tablero.getInstance().inicializarTablero();
        Jugador jugador = new Jugador("JugadorTest");
        Castillo castillo = new Castillo();
        Posicion posicion =  new Posicion(18,18);
        ArmaDeAsedio arma=castillo.crearArmaDeAsedio(jugador,posicion);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Assert.assertEquals(lista_unidades.size(),4);
    }
}