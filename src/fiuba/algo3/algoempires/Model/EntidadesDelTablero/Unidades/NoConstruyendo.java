package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaConstruyendoException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class NoConstruyendo implements Construccion {

	@Override
	public void construir(Construible construible, Posicion posicion) throws AldeanoYaEstaConstruyendoException, FueraDelMapaException {
		construible.construiteEn(posicion);
	}

}
