package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;



public class Cuartel extends Edificio implements Construible, Posicionable{

	private static final int MAX_VIDA = 250;
	static final int COSTO=50;
	static final int TURNOSCONTRUCCION=3;
	static final int OCUPA_ANCHO = 2;
	static final int OCUPA_ALTO = 2;

	public Cuartel() {
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


	//estos get son para las pruebas...despues los saco
	public int getCosto() {
		return COSTO;
	}
	public int getVida() {
		return vida;
	}

	public void reparate(Aldeano aldeano) {
		if (this.vida < MAX_VIDA) {
			this.vida += 50;
		}
		else {
			aldeano.deshabilitarReparacion();
		}
	}


	public Arquero crearArquero(Jugador jugador,Posicion posicion) throws OroInsuficienteException, ExcedeTopePoblacionalException {
		if (jugador.getOro()<75) throw new OroInsuficienteException();
		jugador.modificarOro(-75);
		Arquero arquero = new Arquero(jugador,posicion);
		jugador.agregarUnidad(arquero);
		return arquero;
	}



	public Espadachin crearEspadachin(Jugador jugador,Posicion posicion) throws OroInsuficienteException, ExcedeTopePoblacionalException {
		if (jugador.getOro()<100) throw new OroInsuficienteException();
		jugador.modificarOro(-100);
		Espadachin espadachin = new Espadachin(jugador,posicion);
		jugador.agregarUnidad(espadachin);
		return espadachin;
	}

}

