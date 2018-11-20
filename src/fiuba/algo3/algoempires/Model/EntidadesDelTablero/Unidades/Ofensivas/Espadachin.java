package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Ofensiva;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;

public class Espadachin extends Ofensiva {
    private final int MAX_HP = 100;
    private final int COSTO = 50;
    private final int MAX_RANGO = 1;

    public Espadachin (Jugador jugador, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.posicion = posicion;
        this.rango = MAX_RANGO;
    }

	@Override
	public boolean estaVacio() {
		return false;
	}
	@Override
	public int cuantoDanioAUnidad() {
		return 25;
	}
	
	@Override
	public int cuantoDanioAEdificio() {
		return 15;
	}
}
