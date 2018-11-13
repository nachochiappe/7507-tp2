package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public abstract class Edificio {
	//vida
	public int vida;
	Tablero tablero;
	Posicion posicionInicial;
	Posicion posicionFinal;
	
	public boolean estaVacio() {
		return false;
	}
	
	public void reparate(Aldeano aldeano) {
	   
    }
	
	public Posicion obtenerPosicionInicial() {
		return posicionInicial;
	}
	public Posicion obtenerPosicionFinal() {
		return posicionFinal;
	}
}