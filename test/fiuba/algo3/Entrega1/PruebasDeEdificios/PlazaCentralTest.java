package fiuba.algo3.Entrega1.PruebasDeEdificios;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class PlazaCentralTest {
    
	@Test
    public void testPlazaCentralSeCreaEnCeroCeroYOcupa2x2(){
        Tablero tablero = new Tablero();
        tablero.inicializarTablero();
		PlazaCentral plaza = new PlazaCentral(tablero);
        Posicion posicionInicial = new Posicion(0,0);
        plaza.construiteEn(posicionInicial);
        Assert.assertTrue(plaza.obtenerPosicionInicial().dentroDe(0,0));
        Assert.assertTrue(plaza.obtenerPosicionFinal().dentroDe(1,1));
    }

	@Test
    public void testDosPlazasCentralesSeCreaEnCeroCeroYOcupa2x2YLaOtraASuDerecha(){
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
	
}
