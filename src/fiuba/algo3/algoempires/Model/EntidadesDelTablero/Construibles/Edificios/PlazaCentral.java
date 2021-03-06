package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.LugarVacio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaPlazaCentral;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaPosicionable;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class PlazaCentral extends Edificio {

	private static final int MAX_VIDA = 450;
	private static final int HP_REGEN = 25;
	private static final int COSTO=100;
	private static final int TURNOSCONTRUCCION=3;
	private static final int OCUPA_ANCHO = 2;
	private static final int OCUPA_ALTO = 2;

	public PlazaCentral() {
		this.vida = MAX_VIDA;
	}


	//Constructor llamado únicamente al principio del juego
	public PlazaCentral(Posicion posicion, Jugador jugador) {
		this.vida = MAX_VIDA;
		for (int i = 0; i < OCUPA_ANCHO; i++) {
        	for (int j = 0; j < OCUPA_ALTO; j++) {
        		this.posiciones.add(new Posicion(posicion.getPosicionX() + i, posicion.getPosicionY() + j));
        	}
        }
		Tablero.getInstance().poner(this, this.posiciones);
		this.jugador = jugador;
	}

	@Override
	public Image getSpriteConstruido() {
		return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/PlazaCentral/PlazaCentralConstruida.png");
	}

	@Override
	public Image getSpriteConstruyendo() {
		return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/PlazaCentral/PlazaCentralEnConstruccion.png");
	}

	@Override
	public String getSpriteConstruidoPath() {
		return "file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/PlazaCentral/PlazaCentralConstruida.png";
	}

	@Override
	public String getSpriteConstruyendoPath() {
		return "file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/PlazaCentral/PlazaCentralEnConstruccion.png";
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
	public VBox _getBotoneraAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
		return botoneraAcciones.generarBotonera(contenedor, this);
	}

	@Override
	public String getNombre() {
		return "Plaza Central";
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



	//estos get son para las pruebas...despues los saco
	public int getCosto() {
		return COSTO;
	}




	@Override
	public void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException {
		this.recibeDanioDe(ofensivo);
		
	}


	@Override
	public VistaPosicionable getView(ContenedorPantallaDeJuego contenedor, Jugador jugadorActual) {
		VistaPlazaCentral vistaPlazaCentral = new VistaPlazaCentral(contenedor, this, jugadorActual);
		return vistaPlazaCentral;
	}

}
