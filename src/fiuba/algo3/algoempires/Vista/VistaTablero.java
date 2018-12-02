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
	

	public VistaTablero() {
	}

	
	public void agregar(VistaUnidad vistaUnidad) {
		this.add(vistaUnidad,vistaUnidad.getPosX(),vistaUnidad.getPosY());
	}



	public void iniciarTablero() {
    	Tablero tablero = Tablero.getInstance();
    	
    	for (int i = 0; i < tablero.getAncho(); i++) {
    		for (int j = 0; j < tablero.getAlto(); j++) {
    			StackPane stackPane = new StackPane();
    			Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
    			//System.out.println(pisoVacio.getUrl().replace(".png","-alt") + ".png");
    			ImageView imageView = new ImageView();
    			imageView.setImage(pisoVacio);
    			imageView.setFitWidth(40);
    			imageView.setPreserveRatio(true);
    			imageView.setSmooth(true);
    			imageView.setCache(true);
    			Image sprite = tablero.obtenerPosicionable(i, j).getSprite();
    			ImageView imageViewSprite = new ImageView();
    			imageViewSprite.setImage(sprite);
    			imageViewSprite.setFitWidth(40);
    			imageViewSprite.setPreserveRatio(true);
    			imageViewSprite.setSmooth(true);
    			imageViewSprite.setCache(true);
    			stackPane.getChildren().addAll(imageView, imageViewSprite);
                this.add(stackPane, j, i);
    		}
    	}
		
	}
}
