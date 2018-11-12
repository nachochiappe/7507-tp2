package fiuba.algo3.algoempires.Model;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.PlazaCentral;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

import java.util.HashMap;


public class AlgoEmpires {

    private final int JUGADORES_NECESARIOS = 2;
	
	private HashMap<String, Jugador> jugadores;
	private Tablero tablero;

	public AlgoEmpires() {
	    jugadores = new HashMap<>();
    }
	
	public void inicializarTablero() {
		tablero = new Tablero();
		tablero.inicializarTablero();
	}

	public boolean elMapaEstaVacio() {
		return tablero.estasVacio();
	}

	public void agregarPlazaCentralInicial() {
		Posicionable plazaCentral = new PlazaCentral(tablero);
		Posicion posicionDeInicio = new Posicion(0,0);
		Posicion posicionDeFin = new Posicion(1,1);
		tablero.poner(plazaCentral,posicionDeInicio,posicionDeFin);
	}

	public void agregarJugador(String unNombre) {
	    jugadores.put(unNombre, new Jugador(unNombre, tablero));
    }

    public HashMap<String, Jugador> getJugadores() {
        return jugadores;
    }

    public boolean sePuedeEmpezarAJugar() {
	    return jugadores.size() == JUGADORES_NECESARIOS;
    }
}
