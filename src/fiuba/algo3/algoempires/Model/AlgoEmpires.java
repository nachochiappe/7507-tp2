package fiuba.algo3.algoempires.Model;

import fiuba.algo3.algoempires.Model.Jugador.Jugador;

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
		Construible plazaCentral = new PlazaCentral();
		tablero.construir(plazaCentral,0,0);
	}

	public void agregarJugador(String unNombre) {
	    jugadores.put(unNombre, new Jugador(unNombre));
    }

    public HashMap<String, Jugador> getJugadores() {
        return jugadores;
    }

    public boolean sePuedeEmpezarAJugar() {
	    return jugadores.size() == JUGADORES_NECESARIOS;
    }
}
