package fiuba.algo3.algoempires.Model.EntidadesDelTablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public interface Posicionable {
	public boolean estaVacio();

	public void atacadoPor(Ofensiva ofensivo);
	public boolean estasEnRango(Posicion posicion, int rango);

}
