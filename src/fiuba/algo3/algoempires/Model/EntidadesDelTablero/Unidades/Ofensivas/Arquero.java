package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensiva;
import fiuba.algo3.algoempires.Model.Tablero;

public class Arquero extends Ofensiva {
    private final int MAX_HP = 75;
    private final int COSTO = 75;
    Tablero tablero;

    public Arquero(Tablero tablero, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.tablero = tablero;
        this.posicion = posicion;
    }
}
