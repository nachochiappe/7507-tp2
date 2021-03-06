package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class ArmaDeAsedio extends Unidad implements Ofensiva {

    private final int MAX_HP = 150;
    private final int COSTO = 200;
    private final int MAX_RANGO = 5;

    private ArmaDeAsedioEstado estado;
    private ArmaDeAsedioMontada montada;
    private ArmaDeAsedioDesmontada desmontada;
    private int rango;


    public ArmaDeAsedio(Jugador jugador, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        montada = new ArmaDeAsedioMontada(this);
        desmontada = new ArmaDeAsedioDesmontada(this);
        estado = desmontada;
        this.posicion = posicion;
        this.rango = MAX_RANGO;
        this.jugador = jugador;
    }

    public void mover(Desplazamiento desplazamiento) throws DestinoFueraDelMapaException, UnidadYaSeMovioException, PosicionOcupadaException {
        try {
            this.estado.mover(desplazamiento);
            this.movimiento.mover(desplazamiento, this);
            this.deshabilitarMovimiento();
            return;
        } catch (ArmaDeAsedioMontadaException armaDeAsedioException) {
            armaDeAsedioException.printStackTrace();
        }
    }

    @Override
    public String getNombre() {
        return this.estado.getNombre();
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }

    public void toggleMontar() {
        this.estado.toggleMontar();
    }

    public void setEstado(ArmaDeAsedioEstado estado) {
        this.estado = estado;
    }

    public ArmaDeAsedioDesmontada getDesmontada() {
        return desmontada;
    }

    public ArmaDeAsedioMontada getMontada() {
        return montada;
    }

	@Override
	public boolean estaVacio() {
		return false;
	}

	@Override
	public int cuantoDanioAUnidad() throws ArmaDeAsedioNoAtacaUnidadesException {
		throw new ArmaDeAsedioNoAtacaUnidadesException();

	}

	@Override
	public int cuantoDanioAEdificio() {
		return 75;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException {
		this.recibeDanioDe(ofensivo);

	}

    @Override
    public Image getSprite() {
        return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/ArmaDeAsedio/ArmaDeAsedioS.png");
    }

    @Override
    public String getSpritePath() {
        return "file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/ArmaDeAsedio/ArmaDeAsedioS.png";
    }

    @Override
	public void atacar(Posicionable posicionable)throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
    	if(!posicionable.estasEnRango(this.getPosicion(), this.rango)) throw new ObjetivoFueraDeRangoException();
			this.estado.atacar(posicionable);
	}

    public VBox getBotoneraAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
        return this.estado.getBotoneraAcciones(contenedor, botoneraAcciones);
    }

}
