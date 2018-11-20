package fiuba.algo3.Entrega1.PruebasDelMapa;

import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Tamanio {

    @Test
    public void testAnchoDelTableroEsCorrecto(){
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Assert.assertEquals(20, tablero.getAncho());
    }

    @Test
    public void testAltoDelTableroEsCorrecto(){
        Tablero tablero = Tablero.getInstance();
        tablero.inicializarTablero();
        Assert.assertEquals(20, tablero.getAlto());
    }
}
