package fiuba.algo3.algoempires.Model.EntidadesDelTablero;

import fiuba.algo3.algoempires.Model.Excepciones.ConstruccionFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public interface Construible {
	void construiteEn(Posicion posicionDeInicio) throws ConstruccionFueraDelMapaException;
}
