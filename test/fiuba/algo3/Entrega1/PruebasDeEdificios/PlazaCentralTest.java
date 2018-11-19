package fiuba.algo3.Entrega1.PruebasDeEdificios;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class PlazaCentralTest {
    
	@Test
    public void testPlazaCentralSeCreaEnCeroCeroYOcupa2x2() throws FueraDelMapaException{
        Tablero tablero = new Tablero();
        tablero.inicializarTablero();
		PlazaCentral plaza = new PlazaCentral(tablero);
        Posicion posicionInicial = new Posicion(0,0);
        plaza.construiteEn(posicionInicial);
        Assert.assertTrue(plaza.obtenerPosicionInicial().dentroDe(0,0));
        Assert.assertTrue(plaza.obtenerPosicionFinal().dentroDe(1,1));
    }

	@Test
    public void testDosPlazasCentralesSeCreaEnCeroCeroYOcupa2x2YLaOtraASuDerecha() throws FueraDelMapaException{
        Tablero tablero = new Tablero();
        tablero.inicializarTablero();
		PlazaCentral plaza1 = new PlazaCentral(tablero);
        Posicion posicionInicial = new Posicion(0,0);
        plaza1.construiteEn(posicionInicial);
        PlazaCentral plaza2 = new PlazaCentral(tablero);
        Posicion posicionInicial2 = new Posicion(0,2);
        plaza2.construiteEn(posicionInicial2);
        
        Assert.assertTrue(plaza1.obtenerPosicionInicial().dentroDe(0,0));
        Assert.assertTrue(plaza1.obtenerPosicionFinal().dentroDe(1,1));
        
        Assert.assertTrue(plaza2.obtenerPosicionInicial().dentroDe(0,2));
        Assert.assertTrue(plaza2.obtenerPosicionFinal().dentroDe(1,3));
    }

    @Test

    public void testPlazaCentralCreaAldeanoDevuelveUnAldeano(){
        Tablero tablero = new Tablero();
        Jugador jugador=new Jugador("jugadorTest",tablero);
        PlazaCentral plazaCentral= new PlazaCentral(tablero);
        Posicion posicion =  new Posicion(18,18);
        Aldeano aldeano=plazaCentral.crearAldeano(tablero,jugador,posicion);
        Assert.assertEquals(aldeano.getClass(),Aldeano.class);
    }
	@Test
    public void testPlazaCentralSeVuelveLugarVacionCuandoQuedaSinVida() {
		Tablero tablero = Mockito.mock(Tablero.class);
		PlazaCentral plaza = new PlazaCentral(tablero);
		Espadachin espadachin = Mockito.mock(Espadachin.class);
		Mockito.when(espadachin.cuantoDanioAEdificio()).thenReturn(450);
		plaza.recibeDanioDe(espadachin);
		Assert.assertTrue(LugarVacio.class.isInstance(plaza));
	}
}
