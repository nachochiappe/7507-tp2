package fiuba.algo3.Entrega1.PruebasDeEdificios;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class PlazaCentral {
    
	@Test
    public void plazaCentralSeCreaEnCeroCeroYOcupa2x2(){
        PlazaCentral plaza = new PlazaCentral();
        Posicion posicionInicial = new Posicion(0,0);
        Posicion posicionFinal = new Posicion(1,1);
        plaza.construiteEn(posicionInicial,posicionFinal);
        Assert.assertTrue(plaza.posicionInicial.dentroDe(0,0));
        Assert.assertTrue(plaza.posicionFinal.dentroDe(1,1));
    }
}
