package fiuba.algo3.algoempires.Model;

public interface Movimiento {

	public Posicion calcularPosicionSiguiente(Posicion posicion, int ancho, int alto) throws DestinoFueraDelMapaException;

}
