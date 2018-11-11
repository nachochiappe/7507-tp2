package fiuba.algo3.algoempires.Deprecated;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;


public interface Movimiento {

	public Posicion calcularPosicionSiguiente(Posicion posicion, int ancho, int alto) throws DestinoFueraDelMapaException;

}
