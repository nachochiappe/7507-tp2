package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;

public class Construyendo implements EstadoEdilicio{

    Edificio edificio;
    Aldeano aldeano;

    public Construyendo(Edificio edificio, Aldeano aldeano) {
        this.edificio = edificio;
        this.aldeano = aldeano;
    }

    @Override
    public void reparar() {

    }

    @Override
    public void construir() {

    }

    @Override
    public void crearUnidad(Unidad unidad) {

    }
}
