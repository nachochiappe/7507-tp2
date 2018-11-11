package fiuba.algo3.algoempires.Model;

public class MovimientoIzquierda implements Movimiento {

	@Override
	public Posicion calcularPosicionSiguiente(Posicion posicion, int ancho, int alto) throws DestinoFueraDelMapaException {
		Posicion posicion_nueva = new Posicion(posicion.getPosicionX() - 1, posicion.getPosicionY());
		if (!posicion_nueva.dentroDe(ancho, alto)) {
			throw new DestinoFueraDelMapaException("La unidad no puede moverse fuera de los límites del mapa");
		}
		return posicion_nueva;
	}
}
