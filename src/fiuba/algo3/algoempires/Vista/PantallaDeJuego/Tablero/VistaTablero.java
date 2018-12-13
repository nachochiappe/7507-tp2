package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VistaTablero extends GridPane{
	

	public VistaTablero() {
	}

	
	public void agregar(VistaUnidad vistaUnidad) {
		this.add(vistaUnidad,vistaUnidad.getPosY(),vistaUnidad.getPosX());
	}

	public void iniciarTablero(ContenedorPantallaDeJuego contenedor, Jugador jugadorActual) {
    	Tablero tablero = Tablero.getInstance();
    	List<Posicionable> posicionablesDibujados = new ArrayList<>();
    	for (int i = 0; i < tablero.getAncho(); i++) {
    		for (int j = 0; j < tablero.getAlto(); j++) {
    			Posicionable posicionable = tablero.obtenerPosicionable(i, j);
    			if (!(posicionablesDibujados.contains(posicionable))) {
    				VistaPosicionable vistaPosicionable = posicionable.getView(contenedor, jugadorActual);
        			vistaPosicionable.agregarATablero(this, posicionable, i, j);
        			posicionablesDibujados.add(posicionable);
    			}
    		}
    	}		
	}
}
