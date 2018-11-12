package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public abstract class Edificio {
	//vida
	public int vida;
	Posicion posicionInicial;
	Posicion posicionFinal;

	public void construiteEn(Posicion posicionDeInicio, Posicion posicionDeFin) {
		posicionInicial = posicionDeInicio;
		posicionFinal = posicionDeFin;
	}
	public void  reparate(Unidad Unidad) {
	   
   }
}