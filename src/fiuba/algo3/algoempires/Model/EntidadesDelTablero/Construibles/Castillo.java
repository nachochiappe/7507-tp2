package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;

public class Castillo extends Edificio implements Construible{

	private static final int MAX_VIDA = 1000;
	public int vida = MAX_VIDA;

	public void construiteEn(Posicion posicionDeInicio) {
	}
	
	public int getVida() {
		return vida;
	}
	
	public void reparate(Aldeano aldeano) {
		if (this.vida < MAX_VIDA) {
			this.vida += 15;
		}
		else {
			aldeano.deshabilitarReparacion();
		}
	}
}
