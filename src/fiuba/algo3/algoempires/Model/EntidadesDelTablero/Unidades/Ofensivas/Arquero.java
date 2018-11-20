package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensiva;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;

public class Arquero extends Ofensiva {
    private final int MAX_HP = 75;
    private final int COSTO = 75;
    private final int MAX_RANGO = 3;

    public Arquero(Jugador jugador, Posicion posicion) {
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
		return 15;
	}
	
	@Override
	public int cuantoDanioAEdificio() {
		return 10;
	}	
	
}
