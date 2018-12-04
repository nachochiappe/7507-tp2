package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import java.util.List;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class VistaEdificio extends VistaPosicionable {
	
	protected Edificio edificio;
	protected Image imagenEdificio;
	protected List<StackPane> stackPanes;
	protected List<WritableImage> writableImages;
	protected int anchoEdificio;
	protected int altoEdificio;
	protected VBox unitVBox;
	protected BorderPane borderPane;
	
	protected abstract void mostrarMenuEdificio();

	public void inicializar() {
		PixelReader edificio = this.imagenEdificio.getPixelReader();
		int pixels = 0;
		for (int i = 0; i < 2; i++) {
			this.writableImages.add(new WritableImage(edificio, 0, pixels, 32, 32));
			this.writableImages.add(new WritableImage(edificio, 32, pixels, 32, 32));
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
	
	@Override
    public void agregarATablero(VistaTablero vistaTablero, Posicionable _edificio, int posX, int posY) {
		Edificio edificio = (Edificio) _edificio;
    	int posicionFinalX = edificio.obtenerPosicionFinal().getPosicionX();
    	int posicionFinalY = edificio.obtenerPosicionFinal().getPosicionY();
    	int k = 0;
    	for (int i = posX; i <= posicionFinalX; i++) {
    		for (int j = posY; j <= posicionFinalY; j++) {
    			StackPane stackPane = stackPanes.get(k);
    			vistaTablero.add(stackPane, j, i);
    			k++;
    		}
    	}
    }
}
