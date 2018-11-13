package fiuba.algo3.Entrega1.PruebasDelMapa;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;

public class ColocarUnidadesYEdificios {
	@Test(expected = ConstruccionFueraDelMapaException.class)
    public void testConstruirPlazaCentralEnBordeLevantaError() throws ConstruccionFueraDelMapaException{
    	Tablero tablero = new Tablero();
    	Posicion posicion = new Posicion(19,19);
    	PlazaCentral plaza = new PlazaCentral(tablero);
    	plaza.construiteEn(posicion);
    }
}
