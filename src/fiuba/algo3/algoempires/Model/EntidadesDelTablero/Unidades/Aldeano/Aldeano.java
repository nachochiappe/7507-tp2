package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoOcupadoException;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaConstruyendoException;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaReparandoException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
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
		this.estado.comenzarTurno();
	}

	public void empezarConstruccion(Edificio edificio, Posicion posicion) throws AldeanoOcupadoException, FueraDelMapaException {
		this.estado.empezarConstruccion(edificio, posicion);
	}

	public void construir(Edificio edificio) throws AldeanoOcupadoException {
		this.estado.construir(edificio);
	}

	public void reparar(Edificio edificio) throws AldeanoOcupadoException {
    	this.estado.reparar(edificio);
	}

	public void empezarAConstruir(Edificio edificio) {
		this.estado = new Construyendo(this, edificio);
	}

	public void empezarAReparar(Edificio edificio) {
		this.estado = new Reparando(this, edificio);
	}

	public void terminarAccion() {
		this.estado = new Idle(this);
	}

	public void sumarOro() {
		this.jugador.agregarOro(ORO_POR_TURNO);
	}

	@Override
	public boolean estaVacio() {
		return false;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) {
		this.recibeDanioDe(ofensivo);
	}

}
