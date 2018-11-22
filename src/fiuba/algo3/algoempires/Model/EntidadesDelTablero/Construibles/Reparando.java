package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;

public class Reparando implements EstadoEdilicio {


    Edificio edificio;
    Aldeano aldeano;

    public Reparando(Edificio edificio, Aldeano aldeano) {
        this.edificio = edificio;
        this.aldeano = aldeano;
    }

    @Override
    public void comenzarTurno() {
        this.edificio.reparar(aldeano);
    }

    @Override
    public void crearUnidad() {

    }
}
