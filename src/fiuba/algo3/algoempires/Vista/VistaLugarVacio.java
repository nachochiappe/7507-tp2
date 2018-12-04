package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class VistaLugarVacio extends VistaUnidad{
	
	private Image pisoVacio;
	
	public VistaLugarVacio(BorderPane borderPane) {
		pisoVacio  = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
		this.borderPane = borderPane;
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
		imageViewPiso.setOnMouseClicked(e -> {
			this.borderPane.setCenter(new SeleccionableHUD());
		});
	}

	@Override
    public void agregarATablero(VistaTablero vistaTablero, Posicionable posicionable, int i, int j) {
    	vistaTablero.add(this, j, i);
    }
}
