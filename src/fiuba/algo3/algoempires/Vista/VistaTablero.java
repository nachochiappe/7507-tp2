package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Model.Tablero;
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
    	
    	for (int i = 0; i < tablero.getAncho(); i++) {
    		for (int j = 0; j < tablero.getAlto(); j++) {
    			VistaPosicionable vistaPosicionable = tablero.obtenerPosicionable(i, j).getView(unitVBox, leftBorderPane);
                this.add(vistaPosicionable, j, i);
    		}
    	}
		
	}
}
