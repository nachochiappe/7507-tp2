package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;


public class Cuartel extends Edificio implements Construible, Posicionable{

	private static final int MAX_VIDA = 250;
	public int vida = MAX_VIDA;
	static final int COSTO=50;
	static final int TURNOSCONTRUCCION=3;
	static final int OCUPA_ANCHO = 2;
	static final int OCUPA_ALTO = 2;
	
	public Cuartel(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public void construiteEn(Posicion posicionDeInicio) throws FueraDelMapaException{
		posicionInicial = posicionDeInicio;
		Posicion posicionDeFin = posicionInicial.mismosValores(posicionInicial);
		posicionDeFin.aumentarAncho(OCUPA_ANCHO-1);
		posicionDeFin.aumentarAlto(OCUPA_ALTO-1);
		posicionFinal = posicionDeFin;
		try {
			this.tablero.poner(this, posicionDeInicio, posicionDeFin);
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

	public Arquero crearArquero(Tablero tablero,Jugador jugador,Posicion posicion){
		//falta crear la excepcion
		//if (jugador.getOro()<75) throw new OroInsuficienteException();
		Arquero arquero = new Arquero(tablero,jugador,posicion);
		jugador.agregarUnidad(arquero);
		return arquero;
	}

	public Espadachin crearEspadachin(Tablero tablero,Jugador jugador,Posicion posicion){
		//falta crear la excepcion
		//if (jugador.getOro()<75) throw new OroInsuficienteException();
		Espadachin espadachin = new Espadachin(tablero,jugador,posicion);
		jugador.agregarUnidad(espadachin);
		return espadachin;
	}

}
