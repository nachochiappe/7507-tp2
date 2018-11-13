package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaReparandoException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public interface Reparacion {
	void reparar(Edificio edificio, Aldeano aldeano) throws AldeanoYaEstaReparandoException;
}
