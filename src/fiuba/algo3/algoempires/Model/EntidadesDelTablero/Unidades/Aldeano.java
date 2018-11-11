package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Tablero;

public class Aldeano extends Unidad {

    private final int MAX_HP = 50;
    private final int COSTO = 25;
    Tablero tablero;

    public Aldeano(Tablero _tablero, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.tablero = _tablero;
        this.posicion = posicion;
    }

}
