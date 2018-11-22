package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoOcupadoException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class Reparando implements EstadoAldeano {

	private Aldeano aldeano;
	private Edificio edificio;

	public Reparando(Aldeano aldeano, Edificio edificio) {
		this.aldeano = aldeano;
		this.edificio = edificio;
	}

	@Override
	public void comenzarTurno() {
		this.edificio.reparar(this.aldeano);
	}

	@Override
	public void reparar(Edificio edificio) throws AldeanoOcupadoException {
		throw new AldeanoOcupadoException();
	}

	@Override
	public void construir(Edificio edificio) throws AldeanoOcupadoException {
		throw new AldeanoOcupadoException();
	}

	@Override
	public void terminarAccion() {
		this.edificio.desligarAldeano();
	}

	@Override
	public void empezarConstruccion(Edificio edificio, Posicion posicion) throws AldeanoOcupadoException {
		throw new AldeanoOcupadoException();
	}

}
