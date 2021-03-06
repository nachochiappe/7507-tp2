package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.AtaqueAliadoException;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class Espadachin extends Unidad implements Ofensiva {
    private final int MAX_HP = 100;
    private final int COSTO = 50;
    private final int MAX_RANGO = 1;
    private int rango;
    public Espadachin (Jugador jugador, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.posicion = posicion;
        this.rango = MAX_RANGO;
        this.jugador = jugador;
    }

	public void atacar(Posicionable posicionable) throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException, AtaqueAliadoException {
    	if(!posicionable.estasEnRango(this.getPosicion(), rango)) throw new ObjetivoFueraDeRangoException();
		if (this.jugador.equals(posicionable.getJugador())) throw new AtaqueAliadoException();
		posicionable.atacadoPor(this);
	}

    
    @Override
	public boolean estaVacio() {
		return false;
	}
	public int cuantoDanioAUnidad() throws ArmaDeAsedioNoAtacaUnidadesException {
		return 25;
	}
	
	public int cuantoDanioAEdificio() {
		return 15;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException {
		this.recibeDanioDe(ofensivo);
	}

	@Override
	public Image getSprite() {
		return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Espadachin/EspadachinS.png");
	}

	@Override
	public String getSpritePath() {
		return "file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Espadachin/EspadachinS.png";
	}

	public int getMaxHp() {
		return MAX_HP;
	}

	@Override
	public VBox getBotoneraAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
		return botoneraAcciones.generarBotonera(contenedor, this);
	}

	@Override
	public String getNombre() {
		return "Espadachín";
	}

}
