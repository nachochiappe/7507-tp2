package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Model.Tablero;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaTablero extends GridPane{
	
	private int rowNum = 20;
	private int colNum = 20;
	public VistaTablero() {
	}

	
	public void agregar(VistaAldeano vistaAldeano) {
		this.add(vistaAldeano,10,10);
	}
	public void agregar(VistaEspadachin vistaEspadachin) {
		this.add(vistaEspadachin,10,11);
	}
	public void agregar(VistaArquero vistaArquero) {
		this.add(vistaArquero,10,12);
	}


	public void iniciarTablero() {
    	Tablero tablero = Tablero.getInstance();
    	
    	for (int i = 0; i < tablero.getAncho(); i++) {
    		for (int j = 0; j < tablero.getAlto(); j++) {
    			StackPane stackPane = new StackPane();
    			Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
    			ImageView imageView = new ImageView();
    			imageView.setImage(pisoVacio);
    			imageView.setFitWidth(40);
    			imageView.setPreserveRatio(true);
    			imageView.setSmooth(true);
    			imageView.setCache(true);
    			stackPane.getChildren().add(imageView);
                this.add(stackPane, j, i);
    		}
    	}
		
	}
}
