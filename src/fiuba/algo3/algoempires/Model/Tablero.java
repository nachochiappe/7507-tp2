package fiuba.algo3.algoempires.Model;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class Tablero {
	
	private Posicionable [][] matriz =  new Posicionable[ANCHO][ALTO];;
	static final int ANCHO = 20;
	static final int ALTO = 20;
	
	public void inicializarTablero() {
		for (int i=0; i<ANCHO; i++) {
			for(int j=0; j<ALTO; j++) {
				matriz[i][j] = new LugarVacio();
			}
		}
	}

	public boolean estasVacio() {
		for (int i=0; i<ANCHO; i++) {
			for(int j=0; j<ALTO; j++) {
				if(!(matriz[i][j].estaVacio())) return false;
			}
		}
		return true;
	}

	public void poner(Posicionable posicionable, Posicion posicionDeInicio, Posicion posicionDeFin) {
		for(int i = posicionDeInicio.getPosicionX(); i<=posicionDeFin.getPosicionX(); i++) {
			for(int j = posicionDeInicio.getPosicionX(); j<=posicionDeFin.getPosicionY(); j++) {
				matriz[i][j]= posicionable;
			}
		}
		
	}
	
	public int getAncho() {
		return ANCHO;
	}
	
	public int getAlto() {
		return ALTO;
	}

	public static int ancho() {
		return ANCHO;
	}

	public static int alto() {
		return ANCHO;
	}
}
