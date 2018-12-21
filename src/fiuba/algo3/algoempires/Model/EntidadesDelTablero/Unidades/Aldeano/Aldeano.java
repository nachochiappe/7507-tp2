package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

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
        this.estado = new AldeanoIdle(this);
    }

	public void comenzarTurno() {
    	this.habilitarMovimiento();
		try {
			this.estado.comenzarTurno();
		} catch (EdificioNoNecesitaRepararse | EdificioYaConstruidoException | SoloSePermiteUnAldeanoException edificioNoNecesitaRepararse) {
			//nunca debería llegar acá
			this.estado = new AldeanoIdle(this);
		}
	}

	@Override
	public String getNombre() {
		return "Aldeano";
	}

	public void construir(Edificio edificio, Posicion posicion) throws AldeanoOcupadoException, FueraDelMapaException, SoloSePermiteUnAldeanoException, OroInsuficienteException, PosicionOcupadaException {
		this.estado.empezarConstruccion(edificio, posicion);
	}

	public void empezarAConstruir(Edificio edificio) {
		this.estado = new AldeanoConstruyendo(this, edificio);
	}

	public void terminarAccion() {
		this.estado.terminarAccion();
		this.estado = new AldeanoIdle(this);
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

	@Override
	public Image getSprite() {
		return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Aldeano/AldeanoI.png");
	}

	@Override
	public String getSpritePath() {
		return "file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Aldeano/AldeanoI.png";
	}

	public void reparar(Edificio edificio) throws AldeanoOcupadoException, SoloSePermiteUnAldeanoException, EdificioNoNecesitaRepararse {
		this.estado.empezarReparacion(edificio);
	}

	public int getMaxHp() {
		return MAX_HP;
	}

	public VBox getBotoneraAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
    	return this.estado.getBotonearaAcciones(contenedor, botoneraAcciones);
	}

}
