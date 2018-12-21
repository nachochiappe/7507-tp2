package fiuba.algo3.Entrega2.ReglasDePoblacion;

import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class ReglasDePoblacion {


    @Test
    public void crearUnidadSubePoblacion() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
    	Jugador jugador = new Jugador("jugador");
        PlazaCentral plaza = new PlazaCentral();
        plaza.establecerJugador(jugador);
        Assert.assertEquals(jugador.obtenerPoblacion(), 3);
        plaza.crearUnidad(new Aldeano(jugador, new Posicion(12,12)), new Posicion(12, 12));
        Assert.assertEquals(jugador.obtenerPoblacion(), 4);
    }

    @Test
    public void matarUnidadBajaPoblacion() throws ObjetivoFueraDeRangoException, OroInsuficienteException, ExcedeTopePoblacionalException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException, DestinoFueraDelMapaException, PosicionOcupadaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
    	Jugador jugador = new Jugador("jugador");
        Jugador otroJugador = new Jugador("jugador malo");
        PlazaCentral plaza = new PlazaCentral();
        plaza.establecerJugador(jugador);
        Unidad aldeano = plaza.crearUnidad(new Aldeano(jugador,new Posicion(12, 12)), new Posicion(12, 12));
        Assert.assertEquals(jugador.obtenerPoblacion(), 4);
        Espadachin espadachin = new Espadachin(otroJugador, new Posicion(12,13));
        Espadachin espadachin2 = new Espadachin(otroJugador, new Posicion(12,11));
        espadachin.atacar(aldeano);
        espadachin2.atacar(aldeano);
        Assert.assertEquals(jugador.obtenerPoblacion(), 3);
    }
    
    @Test
    public void testMatarAldeanoReduceProduccionOro() throws OroInsuficienteException, ExcedeTopePoblacionalException, ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException, CantidadJugadoresIncorrectaException, JugadorYaExisteException, DestinoFueraDelMapaException, PosicionOcupadaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
    	AlgoEmpires juego = new AlgoEmpires();
    	juego.agregarJugador("Jugador1");
    	juego.agregarJugador("Jugador2");
    	juego.empezarJuego();
    	Jugador jugador = juego.getJugadorActual();
    	PlazaCentral plaza = new PlazaCentral();
    	plaza.establecerJugador(jugador);
    	Unidad aldeano = plaza.crearUnidad(new Aldeano(jugador, new Posicion(12,12)), new Posicion(12, 12));
    	Assert.assertEquals(jugador.obtenerPoblacion(), 4);
    	Assert.assertEquals(135, jugador.getOro());
    	juego.pasarTurno();
    	Jugador jugadorMalo = juego.getJugadorActual();
    	Espadachin espadachin = new Espadachin(jugadorMalo, new Posicion(12,13));
        Espadachin espadachin2 = new Espadachin(jugadorMalo, new Posicion(12,11));
        espadachin.atacar(aldeano);
        espadachin2.atacar(aldeano);
        juego.pasarTurno();
        Assert.assertEquals(195, jugador.getOro());
    }

    @Test(expected = ExcedeTopePoblacionalException.class)
    public void testNoSePuedeExcederTopePoblacional() throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();
    	Jugador jugador = new Jugador("jugador");
    	PlazaCentral plaza = new PlazaCentral();
    	plaza.establecerJugador(jugador);
    	jugador.modificarOro(5000);
    	for (int i = 0; i <= 19; i++) {
    		for(int j = 0; j <= 19; j++) {
    			Unidad aldeano = plaza.crearUnidad(new Aldeano(jugador, new Posicion(i, j)), new Posicion(i, j));
    		}
    	}

    }
}
