package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Tablero;

public class PlazaCentral extends Edificio implements Construible {
	public void construiteEn(int cordX, int cordY) {
		
	}
	int vida=450;
	static final int COSTO=100;
	static final int TURNOSCONTRUCCION=3;
	
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

	