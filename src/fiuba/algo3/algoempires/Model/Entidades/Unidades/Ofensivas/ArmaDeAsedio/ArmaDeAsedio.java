package fiuba.algo3.algoempires.Model.Entidades.Unidades.Ofensivas.ArmaDeAsedio;

import fiuba.algo3.algoempires.Model.Entidades.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.Entidades.Unidades.Ofensiva;

public class ArmaDeAsedio extends Ofensiva {

    private final int MAX_HP = 150;
    private final int COSTO = 200;

    private ArmaDeAsedioEstado estado;
    private ArmaDeAsedioMontada montada;
    private ArmaDeAsedioDesmontada desmontada;

    public ArmaDeAsedio() {
        this.costo = COSTO;
        this.hp = MAX_HP;
        montada = new ArmaDeAsedioMontada(this);
        desmontada = new ArmaDeAsedioDesmontada(this);
        estado = desmontada;
    }

    public void mover(Desplazamiento desplazamiento) {
        //this.estado.mover(desplazamiento);
    }

    public void atacar(Object edificio) {
        this.estado.atacar(edificio);
    }

    public void toggleMontar() {
        this.estado.toggleMontar();
    }

    public void setEstado(ArmaDeAsedioEstado estado) {
        this.estado = estado;
    }

    public ArmaDeAsedioDesmontada getDesmontada() {
        return desmontada;
    }

    public ArmaDeAsedioMontada getMontada() {
        return montada;
    }

}
