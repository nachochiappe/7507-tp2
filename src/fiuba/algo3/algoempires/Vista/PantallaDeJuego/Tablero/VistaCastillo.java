package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import java.util.ArrayList;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VistaCastillo extends VistaEdificio {

	public VistaCastillo(ContenedorPantallaDeJuego contenedor, Edificio castillo, Jugador jugadorActual) {
		super(contenedor, castillo, jugadorActual);
    	this.imagenEdificio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/Castillo/CastilloConstruido.png");
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
			this.writableImages.add(new WritableImage(castillo, pixels, 0, 32, 32));
			this.writableImages.add(new WritableImage(castillo, pixels, 32, 32, 32));
			this.writableImages.add(new WritableImage(castillo, pixels, 64, 32, 32));
			this.writableImages.add(new WritableImage(castillo, pixels, 96, 32, 32));
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
				this.borderPane.setCenter(new SeleccionableHUD(this.contenedor, this.edificio, jugadorActual));
			});
			stackPane.getChildren().addAll(imageViewPiso, imageView);
			this.stackPanes.add(stackPane);
		}
	}

	@Override
	public Posicion getPosicion() {
		return null;
	}

	@Override
	public void setearClickListener(EventHandler<MouseEvent> eventEventHandler) {

	}
}
