package fiuba.algo3.Entrega1.PruebasDeEdificios;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.ExcedeTopePoblacionalException;
import fiuba.algo3.algoempires.Model.Excepciones.OroInsuficienteException;
import fiuba.algo3.algoempires.Model.Excepciones.PosicionOcupadaException;

import java.util.ArrayList;

public class CuartelTest {
    @Test
    public void testCuartelCreaArqueroDevuelveArquero() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        Cuartel cuartel= new Cuartel();
        cuartel.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad arquero = cuartel.crearUnidad(new Arquero(jugador, posicion),posicion);
        Assert.assertEquals(arquero.getClass(),Arquero.class);
    }
    public void testCuartelCreaEspadachinDevuelveEspadachin() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        Cuartel cuartel= new Cuartel();
        cuartel.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad espadachin=cuartel.crearUnidad(new Espadachin(jugador, posicion),posicion);
        Assert.assertEquals(espadachin.getClass(),Espadachin.class);
    }
    @Test

    public void testCuartelCreaArqueroSumaUnaUnidadAlJugador() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        Cuartel cuartel= new Cuartel();
        cuartel.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad arquero = cuartel.crearUnidad(new Arquero(jugador, posicion),posicion);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Assert.assertEquals(lista_unidades.size(),4);
    }
    @Test
    public void testCuartelCreaEspadachinSumaUnaUnidadAlJugador() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        Cuartel cuartel= new Cuartel();
        cuartel.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad espadachin=cuartel.crearUnidad(new Espadachin(jugador, posicion),posicion);
        ArrayList<Unidad> lista_unidades = jugador.getUnidades();
        Assert.assertEquals(lista_unidades.size(),4);
    }

    public void testCuartelCrearArqueroRestaOro() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException{
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        Cuartel cuartel= new Cuartel();
        cuartel.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad arquero = cuartel.crearUnidad(new Arquero(jugador, posicion),posicion);
        Assert.assertEquals(jugador.getOro(),25);
    }
    public void testCuartelCrearEspadachinRestaOro() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException{
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        Cuartel cuartel= new Cuartel();
        cuartel.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad espadachin=cuartel.crearUnidad(new Espadachin(jugador, posicion),posicion);
        Assert.assertEquals(jugador.getOro(),0);
    }

    @Test(expected=OroInsuficienteException.class)
    public void testCuartelCrearArqueroSinOroLanzaExcepcion() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        jugador.modificarOro(-100);
        Cuartel cuartel= new Cuartel();
        cuartel.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad arquero = cuartel.crearUnidad(new Arquero(jugador, posicion),posicion);
    }

    @Test(expected=OroInsuficienteException.class)
    public void testCuartelCrearEspadachinSinOroLanzaExcepcion() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
        Tablero.getInstance().inicializarTablero();
        Jugador jugador=new Jugador("jugadorTest");
        jugador.modificarOro(-100);
        Cuartel cuartel= new Cuartel();
        cuartel.establecerJugador(jugador);
        Posicion posicion =  new Posicion(18,18);
        Unidad espadachin=cuartel.crearUnidad(new Espadachin(jugador, posicion),posicion);
    }

}
