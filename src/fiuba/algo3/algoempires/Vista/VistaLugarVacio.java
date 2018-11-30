package fiuba.algo3.algoempires.Vista;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class VistaLugarVacio extends StackPane{
	
	Canvas canvas;
	private Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
	
	public VistaLugarVacio() {	
		this.setMaxHeight(32);
		this.setMaxWidth(32);
		this.setMinHeight(32);
		this.setMinWidth(32);
		this.canvas = new Canvas();
		canvas.getGraphicsContext2D().drawImage(pisoVacio, 0, 0);
		this.getChildren().add(canvas);
	}

	public void dibujate() {
		
	}

}
