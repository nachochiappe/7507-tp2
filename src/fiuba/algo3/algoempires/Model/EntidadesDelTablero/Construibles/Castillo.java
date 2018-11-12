package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;

public class Castillo extends Edificio implements Construible{

	int vida=250;

	public void construiteEn(Posicion posicionDeInicio) {
	}
	
	public int getVida() {
		return vida;
	}
	public void reparate(Unidad unidad) {
		
	}
}
