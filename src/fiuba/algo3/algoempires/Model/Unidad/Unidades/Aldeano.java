package fiuba.algo3.algoempires.Model.Unidad.Unidades;

import fiuba.algo3.algoempires.Model.Unidad.Unidad;

public class Aldeano extends Unidad {

    private final int MAX_HP = 50;
    private final int COSTO = 25;

    public Aldeano() {
        this.costo = COSTO;
        this.hp = MAX_HP;
    }
}
