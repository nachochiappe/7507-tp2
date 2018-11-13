package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaReparandoException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class NoReparando implements Reparacion {

	@Override
	public void reparar(Edificio edificio, Aldeano aldeano) throws AldeanoYaEstaReparandoException {
		edificio.reparate(aldeano);
	}
}
