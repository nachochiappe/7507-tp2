package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class PlazaCentral extends Edificio implements Construible{

	int vida=450;
	static final int COSTO=100;
	static final int TURNOSCONTRUCCION=3;
	static final int OCUPA_ANCHO = 2;
	static final int OCUPA_ALTO = 2;
	
	public PlazaCentral(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public void construiteEn(Posicion posicionDeInicio) {
		posicionInicial = posicionDeInicio;
		Posicion posicionDeFin = new Posicion((posicionInicial.getPosicionX()+OCUPA_ANCHO),(posicionInicial.getPosicionY()+OCUPA_ALTO));
		this.tablero.construir(this, posicionDeInicio, posicionDeFin);
	}
		
	public void reparate(Unidad unidad) {
		
	}
	
	//estos get son para las pruebas...despues los saco
	public int getCosto() {
		return COSTO;
	}
	public int getVida() {
		return vida;
	}
	
}