package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class Aldeano extends Unidad {

	private EstadoAldeano estado;
    private final int MAX_HP = 50;
    private final int COSTO = 25;
    private final int ORO_POR_TURNO = 20;

    public Aldeano(Jugador jugador, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.jugador = jugador;
        this.posicion = posicion;
        this.estado = new Idle(this);
    }

	public void comenzarTurno() {
    	this.habilitarMovimiento();
		try {
			this.estado.comenzarTurno();
		} catch (EdificioNoNecesitaRepararse | EdificioYaConstruidoException | SoloSePermiteUnAldeanoException edificioNoNecesitaRepararse) {
			//nunca debería llegar acá
			this.estado = new Idle(this);
		}
	}

	public void construir(Edificio edificio, Posicion posicion) throws AldeanoOcupadoException, FueraDelMapaException, SoloSePermiteUnAldeanoException {
		this.estado.empezarConstruccion(edificio, posicion);
	}

	public void empezarAConstruir(Edificio edificio) {
		this.estado = new Construyendo(this, edificio);
	}

	public void terminarAccion() {
		this.estado.terminarAccion();
	}

	public void sumarOro() {
		this.jugador.agregarOro(ORO_POR_TURNO);
	}

	@Override
	public boolean estaVacio() {
		return false;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException {
		this.recibeDanioDe(ofensivo);
	}

}
