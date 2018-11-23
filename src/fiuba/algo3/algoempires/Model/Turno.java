package fiuba.algo3.algoempires.Model;

import java.util.Collections;
import java.util.List;
import java.util.Iterator;

import fiuba.algo3.algoempires.Model.Excepciones.CantidadJugadoresIncorrectaException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;


public class Turno {
	private List <Jugador> jugadores;
    private Jugador jugadorActual;
    private Iterator<Jugador> it;
    private final int CANTIDAD_JUGADORES = 2;

    public Turno(List <Jugador> listaJugadores) throws CantidadJugadoresIncorrectaException {
        if (listaJugadores.size() != CANTIDAD_JUGADORES) throw new CantidadJugadoresIncorrectaException();
        Collections.shuffle(listaJugadores);
        this.jugadores = listaJugadores;
        this.it = listaJugadores.iterator();
        this.jugadorActual = this.it.next();
        //this.jugadorActual.empezarTurno();
    }

    public void siguienteTurno() {
        if (!this.it.hasNext()) {
        	this.it = jugadores.iterator();
    	}
        this.jugadorActual.terminarTurno();
        this.jugadorActual= this.it.next();
        this.jugadorActual.empezarTurno();
     }

    public Jugador getJugadorActual() {
        return this.jugadorActual;
    }

}
