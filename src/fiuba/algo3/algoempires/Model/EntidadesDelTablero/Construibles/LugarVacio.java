package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class LugarVacio implements Posicionable{
	public boolean estaVacio() {
		return true;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException {
	}

	@Override
	public boolean estasEnRango(Posicion posicion, int rango) {
		return false;
	}
}
