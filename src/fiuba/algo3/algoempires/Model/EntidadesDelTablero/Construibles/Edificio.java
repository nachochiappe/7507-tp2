package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

import java.util.Iterator;
import java.util.LinkedList;

import fiuba.algo3.algoempires.Model.Tablero;

public abstract class Edificio {
	//vida
	public int vida;
	LinkedList<Posicion> posiciones = new LinkedList<Posicion>();

	public boolean estaVacio() {
		return false;
	}

	public void reparate(Aldeano aldeano) {

	}

	public void crearUnidad(Unidad unidad) throws FueraDelMapaException {
		Tablero.getInstance().poner(unidad, unidad.getPosicion(), unidad.getPosicion());
	}

	public Posicion obtenerPosicionInicial() {
		return this.posiciones.getFirst();
	}
	public Posicion obtenerPosicionFinal() {
		return this.posiciones.getLast();
	}

	public int obtenerVida() {
		return this.vida;
	}

	public void recibeDanioDe(Ofensiva ofensivo) {
		int danio = ofensivo.cuantoDanioAEdificio();
		this.vida = this.vida - danio;
	}

	public boolean estasEnRango(Posicion posicionAtacante, int rango) {
		Iterator iterator = posiciones.iterator();
		while (iterator.hasNext()) {
			if(posicionAtacante.estaEnRango((Posicion)iterator.next(), rango))
				return true;
		}
		return false;
	}
}