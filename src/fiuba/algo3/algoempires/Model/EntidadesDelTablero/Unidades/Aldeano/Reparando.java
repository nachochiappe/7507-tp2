package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaReparandoException;

public class Reparando implements Reparacion {

	@Override
	public void reparar(Edificio edificio, Aldeano aldeano) throws AldeanoYaEstaReparandoException {
		throw new AldeanoYaEstaReparandoException();
	}

}
