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

public abstract class Edificio implements Posicionable {
	//vida
	public int vida;
	public int turnosConstruyendo;
	LinkedList<Posicion> posiciones = new LinkedList<Posicion>();
	EstadoEdilicio estadoEdilicio;
	Construyendo construyendo;
	Reparando reparando;

	public boolean estaVacio() {
		return false;
	}

	public void reparate(Aldeano aldeano) {
		this.estadoEdilicio = new Reparando(this, aldeano);
	}

	public void construiteEn(Posicion posicionDeInicio) throws FueraDelMapaException {
		this.posiciones.addFirst(posicionDeInicio);
		for(int i = posicionDeInicio.getPosicionX(); i < posicionDeInicio.getPosicionX() + this.getAlto(); i++) {
			for(int j = posicionDeInicio.getPosicionY(); j < posicionDeInicio.getPosicionY() + this.getAncho(); j++) {
				Posicion posicionActual = new Posicion(i,j);
				posiciones.add(posicionActual);
			}
		}
		try {
			Tablero.getInstance().poner(this , posiciones.getFirst(), posiciones.getLast());
		}
		catch (ArrayIndexOutOfBoundsException e){
			throw new FueraDelMapaException("La construcción está fuera del mapa");
		};
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
		Iterator<Posicion> iterator = posiciones.iterator();
		while (iterator.hasNext()) {
			if(posicionAtacante.estaEnRango(iterator.next(), rango))
				return true;
		}
		return false;
	}

	public void reparar(Aldeano aldeano) {
		this.vida += this.getHpRegen();
		if(this.vida == this.getMaxHp()) {
			aldeano.habilitarReparacion();
			this.estadoEdilicio = new Idle(this);
		}
	}

	public void construir(Aldeano aldeano) {
		turnosConstruyendo++;
		if (turnosConstruyendo == this.getTurnosConstruccion()) {
			aldeano.deshabilitarConstruccion();
		}
	}

	public abstract int getHpRegen();
	public abstract int getMaxHp();
	public abstract int getTurnosConstruccion();
	public abstract int getAlto();
	public abstract int getAncho();
}