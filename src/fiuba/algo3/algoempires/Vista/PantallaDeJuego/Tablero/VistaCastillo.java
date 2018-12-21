package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import java.util.List;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
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
import javafx.scene.layout.StackPane;

public class VistaCastillo extends VistaEdificio {

	public VistaCastillo(ContenedorPantallaDeJuego contenedor, Edificio castillo, Jugador jugadorActual) {
		super(contenedor, castillo, jugadorActual);
		if (castillo.getJugador().equals(contenedor.algoEmpires.getJugadorActual())) {
			this.imagenEdificio = new Image(castillo.getSpritePath());
		} else {
			String imagePath = castillo.getSpritePath().split(".png")[0] + "(Rojo)";
			imagePath = imagePath.concat(".png");
			this.imagenEdificio = new Image(imagePath);
		}
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
			VistaPosicionable vistaPosicionable = edificio.getView(contenedor, jugadorActual);
			ImageView imageView = new ImageView();
			imageView.setImage(writableImages.get(i));
			imageView.setFitWidth(40);
			imageView.setPreserveRatio(true);
			imageView.setSmooth(true);
			imageView.setCache(true);
			imageView.setOnMouseClicked(e -> {
				this.borderPane.setCenter(new SeleccionableHUD(this.contenedor, this.edificio));
			});
			vistaPosicionable.getChildren().addAll(imageViewPiso, imageView);
			this.vistasPosicionables.add(vistaPosicionable);
		}
	}





	@Override
	public void esperarConstruccion(ContenedorPantallaDeJuego contenedor, Aldeano aldeano, Edificio edificio, Posicion posicion, List<VistaPosicionable> vistaPosicionables) {

	}

	@Override
	public void esperarAtaque(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Ofensiva ofensiva,
			Posicion posicion) {
		// TODO Auto-generated method stub
		
	}


}
