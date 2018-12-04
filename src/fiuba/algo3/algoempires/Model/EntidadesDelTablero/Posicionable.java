package fiuba.algo3.algoempires.Model.EntidadesDelTablero;

import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaPosicionable;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public interface Posicionable {
	boolean estaVacio();

	void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException;
	boolean estasEnRango(Posicion posicion, int rango);

	Image getSprite();

	String getNombre();

	int getMaxHp();

	int getHp();

	VBox getBotoneraAcciones(BotoneraAcciones botoneraAcciones);

	VistaPosicionable getView(VBox unitVBox, BorderPane leftBorderPane);

}
