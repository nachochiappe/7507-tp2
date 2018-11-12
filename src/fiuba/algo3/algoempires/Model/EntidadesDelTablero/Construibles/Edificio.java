package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Tablero;
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
	
	public void  reparate(Unidad Unidad) {
	   
    }
	
	public Posicion obtenerPosicionInicial() {
		return posicionInicial;
	}
	public Posicion obtenerPosicionFinal() {
		return posicionFinal;
	}
}