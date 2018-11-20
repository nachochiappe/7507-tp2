package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.ExcedeTopePoblacionalException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;

import fiuba.algo3.algoempires.Model.Tablero;

import fiuba.algo3.algoempires.Model.Excepciones.OroInsuficienteException;


public class PlazaCentral extends Edificio implements Construible, Posicionable{

	private static final int MAX_VIDA = 450;
	static final int COSTO=100;
	static final int TURNOSCONTRUCCION=3;
	static final int OCUPA_ANCHO = 2;
	static final int OCUPA_ALTO = 2;

	public PlazaCentral() {
		this.vida = MAX_VIDA;
	}

	public void construiteEn(Posicion posicionDeInicio) throws FueraDelMapaException {
		this.posiciones.addFirst(posicionDeInicio);
		for(int i = posicionDeInicio.getPosicionX(); i < posicionDeInicio.getPosicionX() + OCUPA_ALTO; i++) {
			for(int j = posicionDeInicio.getPosicionY(); j < posicionDeInicio.getPosicionY() + OCUPA_ANCHO; j++) {
				Posicion posicionActual = new Posicion(i,j);
				posiciones.add(posicionActual);
			}
		}
		try {
			Tablero.getInstance().poner(this, posiciones.getFirst(), posiciones.getLast());
		}
		catch (ArrayIndexOutOfBoundsException e){
			throw new FueraDelMapaException("La construcción está fuera del mapa");
		};
	}

	public void reparate(Aldeano aldeano) {
		if (this.vida < MAX_VIDA) {
			this.vida += 25;
		}
		else {
			aldeano.deshabilitarReparacion();
		}
	}

	public void mori() {
		LugarVacio lugar = LugarVacio.class.cast(this);
	}

	//estos get son para las pruebas...despues los saco
	public int getCosto() {
		return COSTO;
	}
	public int getVida() {
		return vida;
	}



	private void estoyDestruido() {
		if(vida <= 0) {
			this.mori();
		}

	}

	public Aldeano crearAldeano(Jugador jugador,Posicion posicion)  throws OroInsuficienteException, ExcedeTopePoblacionalException {
		if (jugador.getOro()<25) throw new OroInsuficienteException();
		jugador.modificarOro(-25);
		Aldeano aldeano = new Aldeano(jugador,posicion);
		jugador.agregarUnidad(aldeano);
		return aldeano;
	}


}
