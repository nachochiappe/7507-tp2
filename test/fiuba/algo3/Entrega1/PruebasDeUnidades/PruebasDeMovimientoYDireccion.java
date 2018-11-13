package fiuba.algo3.Entrega1.PruebasDeUnidades;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Movimiento.Direccion;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PruebasDeMovimientoYDireccion {

    //--------------ALDEANO----------------

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

    //--------------ARQUERO----------------
    @Test
    public void testArqueroSeMueveParaArribaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(10, 11);
        Arquero arquero = new Arquero(tablero, posicion);
        arquero.mover(Direccion.arriba());
        assertEquals(arquero.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArqueroSeMueveParaAbajoUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(10, 9);
        Arquero arquero = new Arquero(tablero, posicion);
        arquero.mover(Direccion.abajo());
        assertEquals(arquero.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArqueroSeMueveParaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 10);
        Arquero arquero = new Arquero(tablero, posicion);
        arquero.mover(Direccion.izquierda());
        assertEquals(arquero.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArqueroSeMueveParaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 10);
        Arquero arquero = new Arquero(tablero, posicion);
        arquero.mover(Direccion.derecha());
        assertEquals(arquero.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArqueroSeMueveParaArribaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 11);
        Arquero arquero = new Arquero(tablero, posicion);
        arquero.mover(Direccion.arribaIzquierda());
        assertEquals(arquero.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArqueroSeMueveParaArribaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 11);
        Arquero arquero = new Arquero(tablero, posicion);
        arquero.mover(Direccion.arribaDerecha());
        assertEquals(arquero.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArqueroSeMueveParaAbajoIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 9);
        Arquero arquero = new Arquero(tablero, posicion);
        arquero.mover(Direccion.abajoIzquierda());
        assertEquals(arquero.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArqueroSeMueveParaAbajoDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 9);
        Arquero arquero = new Arquero(tablero, posicion);
        arquero.mover(Direccion.abajoDerecha());
        assertEquals(arquero.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test(expected = DestinoFueraDelMapaException.class)
    public void testArqueroNoPuedeSalirDelMapa() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(20, 20);
        Arquero arquero = new Arquero(tablero, posicion);
        arquero.mover(Direccion.arriba());
    }

    @Test(expected = UnidadYaSeMovioException.class)
    public void testArqueroNoSeMueveMasDeUnaVezPorTurno() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Arquero arquero = new Arquero(tablero, posicion);
        arquero.mover(Direccion.arriba());
        arquero.mover(Direccion.arriba());
    }

    //--------------ESPADACHIN----------------
    @Test
    public void testEspadachinSeMueveParaArribaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(10, 11);
        Espadachin espadachin = new Espadachin(tablero, posicion);
        espadachin.mover(Direccion.arriba());
        assertEquals(espadachin.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testEspadachinSeMueveParaAbajoUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(10, 9);
        Espadachin espadachin = new Espadachin(tablero, posicion);
        espadachin.mover(Direccion.abajo());
        assertEquals(espadachin.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testEspadachinSeMueveParaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 10);
        Espadachin espadachin = new Espadachin(tablero, posicion);
        espadachin.mover(Direccion.izquierda());
        assertEquals(espadachin.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testEspadachinSeMueveParaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 10);
        Espadachin espadachin = new Espadachin(tablero, posicion);
        espadachin.mover(Direccion.derecha());
        assertEquals(espadachin.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testEspadachinSeMueveParaArribaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 11);
        Espadachin espadachin = new Espadachin(tablero, posicion);
        espadachin.mover(Direccion.arribaIzquierda());
        assertEquals(espadachin.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testEspadachinSeMueveParaArribaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 11);
        Espadachin espadachin = new Espadachin(tablero, posicion);
        espadachin.mover(Direccion.arribaDerecha());
        assertEquals(espadachin.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testEspadachinSeMueveParaAbajoIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 9);
        Espadachin espadachin = new Espadachin(tablero, posicion);
        espadachin.mover(Direccion.abajoIzquierda());
        assertEquals(espadachin.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testEspadachinSeMueveParaAbajoDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 9);
        Espadachin espadachin = new Espadachin(tablero, posicion);
        espadachin.mover(Direccion.abajoDerecha());
        assertEquals(espadachin.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test(expected = DestinoFueraDelMapaException.class)
    public void testEspadachinNoPuedeSalirDelMapa() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(20, 20);
        Espadachin espadachin = new Espadachin(tablero, posicion);
        espadachin.mover(Direccion.arriba());
    }

    @Test(expected = UnidadYaSeMovioException.class)
    public void testEspadachinNoSeMueveMasDeUnaVezPorTurno() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Espadachin espadachin = new Espadachin(tablero, posicion);
        espadachin.mover(Direccion.arriba());
        espadachin.mover(Direccion.arriba());
    }

    //--------------ARMA DE ASEDIO----------------
    @Test
    public void testArmaDeAsedioSeMueveParaArribaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(10, 11);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, posicion);
        armaDeAsedio.mover(Direccion.arriba());
        assertEquals(armaDeAsedio.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArmaDeAsedioSeMueveParaAbajoUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(10, 9);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, posicion);
        armaDeAsedio.mover(Direccion.abajo());
        assertEquals(armaDeAsedio.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArmaDeAsedioSeMueveParaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, posicion);
        armaDeAsedio.mover(Direccion.izquierda());
        assertEquals(armaDeAsedio.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArmaDeAsedioSeMueveParaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, posicion);
        armaDeAsedio.mover(Direccion.derecha());
        assertEquals(armaDeAsedio.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArmaDeAsedioSeMueveParaArribaIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 11);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, posicion);
        armaDeAsedio.mover(Direccion.arribaIzquierda());
        assertEquals(armaDeAsedio.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArmaDeAsedioSeMueveParaArribaDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 11);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, posicion);
        armaDeAsedio.mover(Direccion.arribaDerecha());
        assertEquals(armaDeAsedio.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArmaDeAsedioSeMueveParaAbajoIzquierdaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(9, 9);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, posicion);
        armaDeAsedio.mover(Direccion.abajoIzquierda());
        assertEquals(armaDeAsedio.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test
    public void testArmaDeAsedioSeMueveParaAbajoDerechaUnCasillero() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        Posicion posicion_nueva = new Posicion(11, 9);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, posicion);
        armaDeAsedio.mover(Direccion.abajoDerecha());
        assertEquals(armaDeAsedio.getPosicion().getPosicionY(), posicion_nueva.getPosicionY());
    }

    @Test(expected = DestinoFueraDelMapaException.class)
    public void testArmaDeAsedioNoPuedeSalirDelMapa() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(20, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, posicion);
        armaDeAsedio.mover(Direccion.arriba());
    }

    @Test(expected = UnidadYaSeMovioException.class)
    public void testArmaDeAsedioNoSeMueveMasDeUnaVezPorTurno() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion(10, 10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(tablero, posicion);
        armaDeAsedio.mover(Direccion.arriba());
        armaDeAsedio.mover(Direccion.arriba());
    }

}