package fiuba.algo3.algoempires.Model.Entidades.Unidades.Ofensivas;

import fiuba.algo3.algoempires.Model.Entidades.Unidades.Ofensiva;

public class Arquero extends Ofensiva {
    private final int MAX_HP = 75;
    private final int COSTO = 75;

    public Arquero() {
        this.costo = COSTO;
        this.hp = MAX_HP;
    }
}
