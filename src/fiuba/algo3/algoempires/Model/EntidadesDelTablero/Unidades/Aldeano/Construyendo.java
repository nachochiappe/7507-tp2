package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaConstruyendoException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class Construyendo implements Construccion {

	@Override
	public void construir(Construible construible, Posicion posicion) throws AldeanoYaEstaConstruyendoException {
		throw new AldeanoYaEstaConstruyendoException();
	}

}
