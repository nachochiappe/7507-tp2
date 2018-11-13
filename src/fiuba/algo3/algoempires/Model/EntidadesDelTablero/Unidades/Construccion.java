package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaConstruyendoException;
import fiuba.algo3.algoempires.Model.Excepciones.ConstruccionFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public interface Construccion {
	void construir(Construible construible, Posicion posicion) throws AldeanoYaEstaConstruyendoException, ConstruccionFueraDelMapaException;
}
