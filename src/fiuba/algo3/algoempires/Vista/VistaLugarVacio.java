package fiuba.algo3.algoempires.Vista;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class VistaLugarVacio extends VistaPosicionable{
	
	private Image pisoVacio;
	
	public VistaLugarVacio() {
		pisoVacio  = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
		inicializar();
	}


	@Override
	public void inicializar() {
		ImageView imageViewPiso = new ImageView();
		imageViewPiso.setImage(pisoVacio);
		imageViewPiso.setFitWidth(40);
		imageViewPiso.setPreserveRatio(true);
		imageViewPiso.setSmooth(true);
		imageViewPiso.setCache(true);
		this.getChildren().add(imageViewPiso);
	}

}
