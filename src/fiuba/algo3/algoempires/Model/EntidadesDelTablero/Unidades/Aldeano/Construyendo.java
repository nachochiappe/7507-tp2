package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoOcupadoException;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioNoNecesitaRepararse;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioYaConstruidoException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class Construyendo implements EstadoAldeano {

	private Aldeano aldeano;
	private Edificio edificio;

	Construyendo(Aldeano aldeano, Edificio edificio) {
		this.aldeano = aldeano;
		this.edificio = edificio;
	}

	@Override
	public void comenzarTurno() throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException {
		this.edificio.edificar(this.aldeano);
	}

	@Override
	public void empezarConstruccion(Edificio edificio, Posicion posicion) throws AldeanoOcupadoException {
		throw new AldeanoOcupadoException();
	}

	@Override
	public void terminarAccion() {
		this.edificio.desligarAldeano();
	}

	@Override
	public void empezarReparacion(Edificio edificio) throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException, AldeanoOcupadoException {
		throw new AldeanoOcupadoException();
		
	}

}
