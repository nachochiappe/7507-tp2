package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioEnConstruccionException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;

public class Construyendo implements EstadoEdilicio{

    private Edificio edificio;

    Construyendo(Edificio edificio) {
        this.edificio = edificio;
    }


    @Override
    public void edificar(Aldeano aldeano) throws SoloSePermiteUnAldeanoException {
        this.edificio.aldeanoValido(aldeano);
        this.edificio._construir(aldeano);
    }

    @Override
    public void crearUnidad(Unidad unidad) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException();
    }
}
