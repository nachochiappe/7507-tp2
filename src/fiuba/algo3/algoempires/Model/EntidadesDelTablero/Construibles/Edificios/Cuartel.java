package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ExcedeTopePoblacionalException;
import fiuba.algo3.algoempires.Model.Excepciones.OroInsuficienteException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaCuartel;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaPosicionable;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Cuartel extends Edificio implements Construible {

	private static final int MAX_VIDA = 250;
	private static final int COSTO=50;
	private static final int HP_REGEN = 50;
	private static final int TURNOSCONTRUCCION=3;
	private static final int OCUPA_ANCHO = 2;
	private static final int OCUPA_ALTO = 2;

	public Cuartel() {
		this.vida = MAX_VIDA;
	}


	//estos get son para las pruebas...despues los saco
	public int getCosto() {
		return COSTO;
	}

	@Override
	public int getHpRegen() {
		return HP_REGEN;
	}

	@Override
	public int getMaxHp() {
		return MAX_VIDA;
	}

	@Override
	public int getHp() {
		return this.vida;
	}


	@Override
	public String getNombre() {
		return "Cuartel";
	}

	@Override
	public VBox _getBotoneraAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
		return botoneraAcciones.generarBotonera(contenedor, this);
	}

	@Override
	public int getTurnosConstruccion() {
		return TURNOSCONTRUCCION;
	}

	@Override
	public int getAlto() {
		return OCUPA_ALTO;
	}

	@Override
	public int getAncho() {
		return OCUPA_ANCHO;
	}


	@Override
	public void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException {
		this.recibeDanioDe(ofensivo);
	}


	@Override
	public Image getSpriteConstruido() {
		return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/Cuartel/CuartelConstruido.png");
	}

	@Override
	public Image getSpriteConstruyendo() {
		return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/Cuartel/CuartelEnConstruccion.png");
	}


	@Override
	public VistaPosicionable getView(ContenedorPantallaDeJuego contenedor, Jugador jugadorActual) {
		VistaCuartel vistaCuartel = new VistaCuartel(contenedor, this, jugadorActual);
		return vistaCuartel;
	}


}

