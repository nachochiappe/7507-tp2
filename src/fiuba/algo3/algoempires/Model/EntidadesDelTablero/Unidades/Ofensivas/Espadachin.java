package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensiva;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Tablero;

public class Espadachin extends Ofensiva {
    private final int MAX_HP = 100;
    private final int COSTO = 50;
    Tablero tablero;

    public Espadachin (Tablero tablero, Jugador jugador, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.tablero = tablero;
        this.posicion = posicion;
    }
}
