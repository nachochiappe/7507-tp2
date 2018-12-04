package fiuba.algo3.algoempires.Vista;

import java.util.ArrayList;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VistaCastillo extends VistaEdificio {

	public VistaCastillo(Edificio castillo, VBox unitVBox, BorderPane borderPane) {
    	this.edificio = castillo;
    	this.anchoEdificio = this.edificio.getAncho();
    	this.altoEdificio = this.edificio.getAlto();
    	this.borderPane = borderPane;
    	this.unitVBox = unitVBox;
    	this.imagenEdificio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/Castillo/CastilloConstruido.png");
    	this.stackPanes = new ArrayList<>();
    	this.writableImages = new ArrayList<>();
    	inicializar();
    }
	
	@Override
	protected void mostrarMenuEdificio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inicializar() {
		PixelReader castillo = this.imagenEdificio.getPixelReader();
		int pixels = 0;
		for (int i = 0; i < 4; i++) {
			this.writableImages.add(new WritableImage(castillo, 0, pixels, 32, 32));
			this.writableImages.add(new WritableImage(castillo, 32, pixels, 32, 32));
			this.writableImages.add(new WritableImage(castillo, 64, pixels, 32, 32));
			this.writableImages.add(new WritableImage(castillo, 96, pixels, 32, 32));
			pixels += 32;
		}
		for (int i = 0; i < this.anchoEdificio * this.altoEdificio; i++) {
			Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
			ImageView imageViewPiso = new ImageView();
			imageViewPiso.setImage(pisoVacio);
			imageViewPiso.setFitWidth(40);
			imageViewPiso.setPreserveRatio(true);
			imageViewPiso.setSmooth(true);
			imageViewPiso.setCache(true);
			StackPane stackPane = new StackPane();
			ImageView imageView = new ImageView();
			imageView.setImage(writableImages.get(i));
			imageView.setFitWidth(40);
			imageView.setPreserveRatio(true);
			imageView.setSmooth(true);
			imageView.setCache(true);
			imageView.setOnMouseClicked(e -> {
				this.borderPane.setCenter(new SeleccionableHUD(this.edificio));
			});
			stackPane.getChildren().addAll(imageViewPiso, imageView);
			this.stackPanes.add(stackPane);
		}
	}
}
