package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;

public class Construyendo implements EstadoEdilicio {

    Edificio edificio;
    Aldeano aldeano;

    public Construyendo(Edificio edificio, Aldeano aldeano) {
        this.edificio = edificio;
        this.aldeano = aldeano;
    }

    @Override
    public void comenzarTurno() {
        this.edificio.construir(aldeano);
    }

    @Override
    public void crearUnidad() {
        //TODO: ARMAR EXCEPCION
    }
}
