package fiuba.algo3.Entrega1.PruebasDelMapa;

import fiuba.algo3.algoempires.Model.TableroS;
import org.junit.Assert;
import org.junit.Test;

public class Tamanio {

    @Test
    public void testAnchoDelTableroEsCorrecto(){
        TableroS tablero = TableroS.getInstance();
        tablero.inicializarTablero();
        Assert.assertEquals(20, tablero.getAncho());
    }

    @Test
    public void testAltoDelTableroEsCorrecto(){
        TableroS tablero = TableroS.getInstance();
        tablero.inicializarTablero();
        Assert.assertEquals(20, tablero.getAlto());
    }
}
