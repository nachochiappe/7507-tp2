package fiuba.algo3.algoempires.Deprecated.AldeanoConstruccionReparacionSumatoriaOro;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaReparandoException;

public interface Reparacion {
	void reparar(Edificio edificio, Aldeano aldeano) throws AldeanoYaEstaReparandoException;
}
