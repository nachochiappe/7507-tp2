package fiuba.algo3.algoempires.Model;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.Excepciones.CantidadJugadoresIncorrectaException;
import fiuba.algo3.algoempires.Model.Excepciones.JugadorYaExisteException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class AlgoEmpires {

    private final int JUGADORES_NECESARIOS = 2;
	
	private HashMap<String, Jugador> jugadores;
	private Tablero tablero;
	private Jugador turnoActual;
	private Turno turno;

	public AlgoEmpires() {
	    jugadores = new HashMap<>();
    }

    public void empezarJuego() throws CantidadJugadoresIncorrectaException {
		//this.inicializarTablero();
		this.turno = new Turno(new ArrayList<>(jugadores.values()));
		this.turnoActual = this.turno.getJugadorActual();
		this.turnoActual.empezarTurno();
	}

	public Jugador getJugadorActual() {
		return this.turno.getJugadorActual();
	}

	public void pasarTurno() {
		this.turno.siguienteTurno();
	}

	public void inicializarTablero() {
		tablero = Tablero.getInstance();
		tablero.inicializarTablero();
	}

	public boolean elMapaEstaVacio() {
		return tablero.estasVacio();
	}


	public void agregarJugador(String unNombre) throws JugadorYaExisteException {
		if(jugadores.containsKey(unNombre)) {
			throw new JugadorYaExisteException();
		}
		jugadores.put(unNombre, new Jugador(unNombre));
    }

	public void agregarJugador(String unNombre, Posicion posicion) throws JugadorYaExisteException {
		if(jugadores.containsKey(unNombre)) {
			throw new JugadorYaExisteException();
		}
		jugadores.put(unNombre, new Jugador(unNombre, posicion));
	}

    public HashMap<String, Jugador> getJugadores() {
        return jugadores;
    }

    public boolean sePuedeEmpezarAJugar() {
	    return jugadores.size() == JUGADORES_NECESARIOS;
    }

	public void setTurnoActual(Jugador jugador) {
		this.turnoActual = jugador;
	}
}
