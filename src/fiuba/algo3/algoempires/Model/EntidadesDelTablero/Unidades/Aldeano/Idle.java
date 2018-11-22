package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class Idle implements EstadoAldeano{

    private Aldeano aldeano;

    Idle(Aldeano aldeano) {
        this.aldeano = aldeano;
    }

    @Override
    public void comenzarTurno() {
        this.aldeano.sumarOro();
    }

    @Override
    public void empezarConstruccion(Edificio edificio, Posicion posicion) throws FueraDelMapaException, SoloSePermiteUnAldeanoException {
        edificio.construiteEn(this.aldeano, posicion);
    }

    @Override
    public void terminarAccion() {

    }

}
