package fiuba.algo3.algoempires.Model.EntidadesDelTablero;

import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import javafx.scene.image.Image;

public interface Posicionable {
	boolean estaVacio();

	void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException;
	boolean estasEnRango(Posicion posicion, int rango);

	Image getSprite();

}
