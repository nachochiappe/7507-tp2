package fiuba.algo3.Entrega2.ReglasDePoblacion;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class ReglasDePoblacion {


    @Test
    public void crearUnidadSubePoblacion() {
        Jugador jugador = new Jugador("jugador");
        Assert.assertEquals(jugador.obtenerPoblacion(), 3);
        jugador.getPlazaCentral().crearAldeano(jugador, new Posicion(12, 12));
        Assert.assertEquals(jugador.obtenerPoblacion(), 4);
    }

    @Test
    public void matarUnidadBajaPoblacion() throws ObjetivoFueraDeRangoException {
        Jugador jugador = new Jugador("jugador");
        Jugador otroJuagador = new Jugador("jugador malo");
        Aldeano aldeano = jugador.getPlazaCentral().crearAldeano(jugador, new Posicion(12, 12));
        Assert.assertEquals(jugador.obtenerPoblacion(), 4);
        Espadachin espadachin = new Espadachin(otroJuagador, new Posicion(12,13));
        Espadachin espadachin2 = new Espadachin(otroJuagador, new Posicion(12,11));
        espadachin.atacar(aldeano);
        espadachin2.atacar(aldeano);
        Assert.assertEquals(jugador.obtenerPoblacion(), 3);
    }

}
