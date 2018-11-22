package fiuba.algo3.algoempires.Deprecated.AldeanoConstruccionReparacionSumatoriaOro;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaReparandoException;

public class NoReparando implements Reparacion {

	@Override
	public void reparar(Edificio edificio, Aldeano aldeano) throws AldeanoYaEstaReparandoException {
		edificio.reparate(aldeano);
	}
}
