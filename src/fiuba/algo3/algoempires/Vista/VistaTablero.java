package fiuba.algo3.algoempires.Vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaTablero extends GridPane{
	

	public VistaTablero() {
	}

	
	public void agregar(VistaUnidad vistaUnidad) {
		this.add(vistaUnidad,vistaUnidad.getPosX(),vistaUnidad.getPosY());
	}



	public void iniciarTablero(VBox unitVBox, BorderPane leftBorderPane) {
    	Tablero tablero = Tablero.getInstance();
    	
    	List<Posicionable> posicionablesDibujados = new ArrayList<>();
    	for (int i = 0; i < tablero.getAncho(); i++) {
    		for (int j = 0; j < tablero.getAlto(); j++) {
    			Posicionable posicionable = tablero.obtenerPosicionable(i, j);
    			if (!(posicionablesDibujados.contains(posicionable))) {
    				VistaPosicionable vistaPosicionable = posicionable.getView(unitVBox, leftBorderPane);
        			vistaPosicionable.agregarATablero(this, posicionable, i, j);
        			posicionablesDibujados.add(posicionable);
    			}
    		}
    	}		
	}
}
