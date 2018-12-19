package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoempires.Controlador.Tablero.Celdas.CeldaAtacable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.Alerts.ContenedorAlerta;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class VistaEdificio extends VistaPosicionable {
	
	protected ContenedorPantallaDeJuego contenedor;
	protected Edificio edificio;
	protected Image imagenEdificio;
	protected List<StackPane> stackPanes;
	protected List<WritableImage> writableImages;
	protected int anchoEdificio;
	protected int altoEdificio;
	protected VBox unitVBox;
	protected BorderPane borderPane;
	protected Jugador jugadorActual;
	Posicion posicion;
	
	protected abstract void mostrarMenuEdificio();
	
	public VistaEdificio(ContenedorPantallaDeJuego _contenedor, Edificio _edificio, Jugador _jugadorActual) {
		this.contenedor = _contenedor;
		this.unitVBox = this.contenedor.unitVBox;
		this.borderPane = this.contenedor.leftBorderPane;
		this.edificio = _edificio;
    	this.anchoEdificio = this.edificio.getAncho();
    	this.altoEdificio = this.edificio.getAlto();
    	this.stackPanes = new ArrayList<>();
    	this.writableImages = new ArrayList<>();
    	this.jugadorActual = _jugadorActual;
	}

	public void inicializar() {
		PixelReader edificio = this.imagenEdificio.getPixelReader();
		int pixels = 0;
		for (int i = 0; i < 2; i++) {
			this.writableImages.add(new WritableImage(edificio, pixels, 0, 32, 32));
			this.writableImages.add(new WritableImage(edificio, pixels, 32, 32, 32));
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
				this.borderPane.setCenter(new SeleccionableHUD(this.contenedor, this.edificio));
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
    			vistaTablero.add(stackPane, i, j);
    			k++;
    		}
    	}
    	posicion = new Posicion(posX, posY);
    }
	
	public void esperarCreacionUnidad(ContenedorPantallaDeJuego contenedor, Edificio edificio, Unidad unidad, Posicion posicion) {
		this.setearClickListener(event -> {
			ContenedorAlerta contenedorAlerta = new ContenedorAlerta();
			contenedorAlerta.display(contenedor.rootStage, "No puede construir aquí");
		});
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	@Override
	public void mostrarSeleccionable() {
		Image seleccionado = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/selec.png");
		ImageView imageViewSeleccionado = new ImageView();
		imageViewSeleccionado.setImage(seleccionado);
		imageViewSeleccionado.setFitWidth(40);
		imageViewSeleccionado.setPreserveRatio(true);
		imageViewSeleccionado.setSmooth(true);
		imageViewSeleccionado.setCache(true);
		getChildren().add(imageViewSeleccionado);
	}

	public void ocultarSeleccionable() {
		getChildren().remove(2);
	}
	
	public void esperarAtaque(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Ofensiva ofensiva, Posicion posicion) {
		this.setearClickListener(new CeldaAtacable(contenedor, ofensiva, edificio, posicion));
		this.setOnMouseEntered(event -> {
	
			Image seleccionado = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/selec.png");
			ImageView imageViewSeleccionado = new ImageView();
			imageViewSeleccionado.setImage(seleccionado);
			imageViewSeleccionado.setFitWidth(40);
			imageViewSeleccionado.setPreserveRatio(true);
			imageViewSeleccionado.setSmooth(true);
			imageViewSeleccionado.setCache(true);
			getChildren().add(imageViewSeleccionado);
			Image sprite =  new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Cursors/SelecAtaque.png");
			ImageCursor imageCursor = new ImageCursor(sprite);
			cursorProperty().set(imageCursor);
	
		});
		this.setOnMouseExited(event -> {
			getChildren().remove(1);
			cursorProperty().set(Cursor.DEFAULT);
		});
	}

}
