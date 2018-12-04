package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaLugarVacio;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaPosicionable;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LugarVacio implements Posicionable{
	public boolean estaVacio() {
		return true;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) {
	}

	@Override
	public boolean estasEnRango(Posicion posicion, int rango) {
		return false;
	}

	@Override
	public Image getSprite() {
		return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
	}

	@Override
	public String getNombre() {
		return null;
	}

	@Override
	public int getMaxHp() {
		return 0;
	}

	@Override
	public int getHp() {
		return 0;
	}

	@Override
	public VBox getBotoneraAcciones(BotoneraAcciones botoneraAcciones) {
		return null;
	}

	@Override
	public VistaPosicionable getView(VBox unitVBox, BorderPane leftBorderPane, Jugador jugadorActual) {
		return new VistaLugarVacio(leftBorderPane);
	}

	@Override
	public Jugador getJugador() {
		return null;
	}
}
