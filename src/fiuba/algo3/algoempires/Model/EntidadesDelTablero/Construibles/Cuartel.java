package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;

public class Cuartel extends Edificio implements Construible{

	public int vida=250;
	static final int COSTO=50;
	static final int TURNOSCONTRUCCION=3;
	
	public void construiteEn(Posicion posicionDeInicio) {
	}
	
	
	//estos get son para las pruebas...despues los saco
	public int getCosto() {
		return COSTO;
	}
	public int getVida() {
		return vida;
	}
	public void reparate(Unidad unidad) {		
	}
}
