package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

import java.util.Iterator;
import java.util.LinkedList;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Vista.MenuPrincipal.ContenedorPantallaPrincipal;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public abstract class Edificio implements Posicionable, Construible {
	//vida
	public int vida;
	private int turnosConstruyendo;
	protected LinkedList<Posicion> posiciones = new LinkedList<Posicion>();
	private EstadoEdilicio estadoEdilicio;
	private Aldeano aldeanoAsignado;
	protected Jugador jugador;

	public boolean estaVacio() {
		return false;
	}


	public void construiteEn(Aldeano aldeano, Posicion posicionDeInicio) throws FueraDelMapaException, SoloSePermiteUnAldeanoException, OroInsuficienteException, PosicionOcupadaException {
//		this.posiciones.addFirst(posicionDeInicio);
		aldeano.getJugador().sacarOro(getCosto());
		for(int i = posicionDeInicio.getPosicionX(); i < posicionDeInicio.getPosicionX() + this.getAlto(); i++) {
			for(int j = posicionDeInicio.getPosicionY(); j < posicionDeInicio.getPosicionY() + this.getAncho(); j++) {
				if (!Tablero.getInstance().obtenerPosicionable(i, j).estaVacio()) {
					throw new PosicionOcupadaException();
				}
				Posicion posicionActual = new Posicion(i,j);
				posiciones.add(posicionActual);
			}
		}
		Tablero.getInstance().poner(this , posiciones.getFirst(), posiciones.getLast());
		aldeanoValido(aldeano);
		this.vida = 50;
		this.jugador = aldeano.getJugador();
		aldeano.empezarAConstruir(this);
		this.estadoEdilicio = new Construyendo(this);
	}

	//public abstract Unidad crearUnidad(Unidad unidad) throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException;

	public Image getSprite() {
		return this.estadoEdilicio.getSprite();
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

	public Unidad crearUnidad(Unidad unidad, Posicion posicion) throws OroInsuficienteException, ExcedeTopePoblacionalException, DestinoFueraDelMapaException, PosicionOcupadaException {
		jugador.sacarOro(unidad.getCosto());
		jugador.agregarUnidad(unidad);
		Tablero.getInstance().poner(posicion, unidad);
		return unidad;
	}

	public VBox getBotoneraAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
		return this.estadoEdilicio.getBotoneraAcciones(contenedor, botoneraAcciones);
	}

	public boolean isFullHp() {
		return this.vida == this.getMaxHp();
	}

	public void desligarAldeano() {
		this.aldeanoAsignado = null;
	}


	public abstract Image getSpriteConstruido();
	public abstract Image getSpriteConstruyendo();


	//------------GETTERS


	public abstract int getHpRegen();
	public abstract int getTurnosConstruccion();
	public abstract int getAlto();
	public abstract int getAncho();
	public abstract int getCosto();
	public Jugador getJugador() {
		return this.jugador;
	}
	public Posicion obtenerPosicionInicial() {
		return this.posiciones.getFirst();
	}
	public Posicion obtenerPosicionFinal() {
		return this.posiciones.getLast();
	}
	
	public void setEstadoEdilicioIdle() {
		this.estadoEdilicio = new Idle(this);
	}

	public abstract VBox _getBotoneraAcciones(ContenedorPantallaDeJuego contenedorPantallaDeJuego, BotoneraAcciones botoneraAcciones);

	public void establecerJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}