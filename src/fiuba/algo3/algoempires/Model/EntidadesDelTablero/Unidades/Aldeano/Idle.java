package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.*;
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
    public void empezarConstruccion(Edificio edificio, Posicion posicion) throws FueraDelMapaException, SoloSePermiteUnAldeanoException, OroInsuficienteException {
        edificio.construiteEn(this.aldeano, posicion);
    }

    @Override
    public void terminarAccion() {

    }

	@Override
	public void empezarReparacion(Edificio edificio) throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException, AldeanoOcupadoException {
		edificio.edificar(this.aldeano);
	}

}
