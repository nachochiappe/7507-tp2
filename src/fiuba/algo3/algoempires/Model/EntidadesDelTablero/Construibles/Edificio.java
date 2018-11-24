package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

import java.util.Iterator;
import java.util.LinkedList;

import fiuba.algo3.algoempires.Model.Tablero;

public abstract class Edificio implements Posicionable, Construible {
	//vida
	public int vida;
	private int turnosConstruyendo;
	protected LinkedList<Posicion> posiciones = new LinkedList<Posicion>();
	private EstadoEdilicio estadoEdilicio;
	private Aldeano aldeanoAsignado;

	public boolean estaVacio() {
		return false;
	}


	public void construiteEn(Aldeano aldeano, Posicion posicionDeInicio) throws FueraDelMapaException, SoloSePermiteUnAldeanoException {
//		this.posiciones.addFirst(posicionDeInicio);
		for(int i = posicionDeInicio.getPosicionX(); i < posicionDeInicio.getPosicionX() + this.getAlto(); i++) {
			for(int j = posicionDeInicio.getPosicionY(); j < posicionDeInicio.getPosicionY() + this.getAncho(); j++) {
				Posicion posicionActual = new Posicion(i,j);
				posiciones.add(posicionActual);
			}
		}
		try {
			Tablero.getInstance().poner(this , posiciones.getFirst(), posiciones.getLast());
			aldeanoValido(aldeano);
			this.vida = 50;
			aldeano.empezarAConstruir(this);
			this.estadoEdilicio = new Construyendo(this);
		}
		catch (ArrayIndexOutOfBoundsException e){
			throw new FueraDelMapaException("La construcción está fuera del mapa");
		};
	}

	public void crearUnidad(Unidad unidad){};

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


	public void edificar(Aldeano aldeano) throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException {
		this.estadoEdilicio.edificar(aldeano);
	}

	public void _reparar(Aldeano aldeano) {
		this.vida += this.getHpRegen();
		if(this.vida == this.getMaxHp()) {
			aldeano.terminarAccion();
		}
	}

	public void _construir(Aldeano aldeano) {
		turnosConstruyendo++;
		if (turnosConstruyendo == this.getTurnosConstruccion()) {
			aldeano.terminarAccion();
			this.vida = this.getMaxHp();
			this.estadoEdilicio = new Idle(this);
		}
	}

	public void aldeanoValido(Aldeano aldeano) throws SoloSePermiteUnAldeanoException {
		if(this.aldeanoAsignado == null) {
			this.aldeanoAsignado = aldeano;
			return;
		} else {
			if (this.aldeanoAsignado != aldeano) {
				throw new SoloSePermiteUnAldeanoException();
			}
		}
	}

	public boolean isFullHp() {
		return this.vida == this.getMaxHp();
	}

	public void desligarAldeano() {
		this.aldeanoAsignado = null;
	}

	//------------GETTERS


	public abstract int getHpRegen();
	public abstract int getMaxHp();
	public abstract int getTurnosConstruccion();
	public abstract int getAlto();
	public abstract int getAncho();

	public Posicion obtenerPosicionInicial() {
		return this.posiciones.getFirst();
	}
	public Posicion obtenerPosicionFinal() {
		return this.posiciones.getLast();
	}
}