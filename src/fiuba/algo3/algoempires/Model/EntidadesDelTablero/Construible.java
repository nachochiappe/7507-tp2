package fiuba.algo3.algoempires.Model.EntidadesDelTablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public interface Construible {
	void construiteEn(Aldeano aldeano, Posicion posicionDeInicio) throws FueraDelMapaException, SoloSePermiteUnAldeanoException;
}
