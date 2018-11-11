package fiuba.algo3.Entrega1;

import fiuba.algo3.algoempires.Model.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Entidades.Movimiento.Direccion;
import fiuba.algo3.algoempires.Model.Entidades.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Entidades.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.UnidadYaSeMovioException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PruebasDeUnidades {

    //--------------ALDEANO TEST----------------

    @Test
    public void testAldeanoSeMueveParaArribaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(10, 11);
        Aldeano aldeano = new Aldeano(tablero, posicion);
        aldeano.mover(Direccion.arriba());
        assertEquals(aldeano.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testAldeanoSeMueveParaAbajoUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(10, 9);
        Aldeano aldeano = new Aldeano(tablero, posicion);
        aldeano.mover(Direccion.abajo());
        assertEquals(aldeano.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testAldeanoSeMueveParaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 10);
        Aldeano aldeano = new Aldeano(tablero, posicion);
        aldeano.mover(Direccion.izquierda());
        assertEquals(aldeano.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testAldeanoSeMueveParaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 10);
        Aldeano aldeano = new Aldeano(tablero, posicion);
        aldeano.mover(Direccion.derecha());
        assertEquals(aldeano.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testAldeanoSeMueveParaArribaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 11);
        Aldeano aldeano = new Aldeano(tablero, posicion);
        aldeano.mover(Direccion.arribaIzquierda());
        assertEquals(aldeano.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testAldeanoSeMueveParaArribaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 11);
        Aldeano aldeano = new Aldeano(tablero, posicion);
        aldeano.mover(Direccion.arribaDerecha());
        assertEquals(aldeano.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testAldeanoSeMueveParaAbajoIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 9);
        Aldeano aldeano = new Aldeano(tablero, posicion);
        aldeano.mover(Direccion.abajoIzquierda());
        assertEquals(aldeano.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testAldeanoSeMueveParaAbajoDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 9);
        Aldeano aldeano = new Aldeano(tablero, posicion);
        aldeano.mover(Direccion.abajoDerecha());
        assertEquals(aldeano.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test(expected = DestinoFueraDelMapaException.class)
    public void testAldeanoNoPuedeSalirDelMapa() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(20, 20);
        Aldeano aldeano = new Aldeano(tablero, posicion);
        aldeano.mover(Direccion.arriba());
    }

    @Test(expected = UnidadYaSeMovioException.class)
    public void testAldeanoNoSeMueveMasDeUnaVezPorTurno() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Aldeano aldeano = new Aldeano(tablero, posicion);
        aldeano.mover(Direccion.arriba());
        aldeano.mover(Direccion.arriba());
    }


}
