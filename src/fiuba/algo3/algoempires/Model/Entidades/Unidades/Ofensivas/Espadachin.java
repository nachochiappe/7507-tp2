package fiuba.algo3.algoempires.Model.Entidades.Unidades.Ofensivas;

import fiuba.algo3.algoempires.Model.Entidades.Unidades.Ofensiva;

public class Espadachin extends Ofensiva {
    private final int MAX_HP = 100;
    private final int COSTO = 50;

    public Espadachin () {
        this.costo = COSTO;
        this.hp = MAX_HP;
    }
}
