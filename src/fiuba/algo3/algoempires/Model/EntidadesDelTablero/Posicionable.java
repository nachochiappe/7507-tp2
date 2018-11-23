package fiuba.algo3.algoempires.Model.EntidadesDelTablero;

import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public interface Posicionable {
	public boolean estaVacio();

	public void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException;
	public boolean estasEnRango(Posicion posicion, int rango);

}
