package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class Arquero extends Unidad implements Ofensiva {
    private final int MAX_HP = 75;
    private final int COSTO = 75;
    private final int MAX_RANGO = 3;
    private int rango;
    public Arquero(Jugador jugador, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.posicion = posicion;
        this.rango = MAX_RANGO;
    }
    
    @Override
	public void atacar(Posicionable posicionable)throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
		if(!posicionable.estasEnRango(this.getPosicion(), rango)) throw new ObjetivoFueraDeRangoException();
		posicionable.atacadoPor(this);
	}

	@Override
	public boolean estaVacio() {
		return false;
	}

	public int cuantoDanioAUnidad() throws ArmaDeAsedioNoAtacaUnidadesException {
		return 15;
	}
	
	public int cuantoDanioAEdificio() {
		return 10;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException {
		this.recibeDanioDe(ofensivo);
	}

	@Override
	public Image getSprite() {
		return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Arquero/ArqueroS.png");
	}

	@Override
	public String getNombre() {
		return "Arquero";
	}

	@Override
	public int getMaxHp() {
		return MAX_HP;
	}

	@Override
	public VBox getBotoneraAcciones(BotoneraAcciones botoneraAcciones) {
		return null;
	}
}
