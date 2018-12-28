package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import fiuba.algo3.algoempires.Controlador.Tablero.Celdas.CeldaAtacable;
import fiuba.algo3.algoempires.Controlador.Tablero.Celdas.CeldaConstruirReparar;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.Alerts.ContenedorAlerta;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public abstract class VistaEdificio extends VistaPosicionable {
	
	protected ContenedorPantallaDeJuego contenedor;
	protected Edificio edificio;
	Image imagenEdificio;
	List<VistaPosicionable> vistasPosicionables;
	List<WritableImage> writableImages;
	int anchoEdificio;
	int altoEdificio;
	private VBox unitVBox;
	BorderPane borderPane;
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
    	this.vistasPosicionables = new ArrayList<>();
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
			imageViewPiso.setFitWidth(35);
			imageViewPiso.setPreserveRatio(true);
			imageViewPiso.setSmooth(true);
			imageViewPiso.setCache(true);
			VistaPosicionable vistaPosicionable = this.edificio.getView(contenedor, jugadorActual);
			ImageView imageView = new ImageView();
			imageView.setImage(writableImages.get(i));
			imageView.setFitWidth(35);
			imageView.setPreserveRatio(true);
			imageView.setSmooth(true);
			imageView.setCache(true);
			vistaPosicionable.setearClickListener(e -> this.borderPane.setCenter(new SeleccionableHUD(this.contenedor, this.edificio)));
			vistaPosicionable.setOnMouseEntered(e-> vistaPosicionable.cursorProperty().set(Cursor.HAND));
			vistaPosicionable.setOnMouseExited(e-> vistaPosicionable.cursorProperty().set(Cursor.DEFAULT));
			vistaPosicionable.getChildren().addAll(imageViewPiso, imageView);
			this.vistasPosicionables.add(vistaPosicionable);
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
				VistaPosicionable stackPane = vistasPosicionables.get(k);
    			vistaTablero.add(stackPane, i, j);
    			vistaTablero.agregarVistaPosicionable(this, i, j);
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
		return this.posicion != null ? this.posicion : this.edificio.obtenerPosicionInicial();
	}

	@Override
	public void mostrarSeleccionable() {
		Image seleccionado = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/selec.png");
		ImageView imageViewSeleccionado = new ImageView();
		imageViewSeleccionado.setImage(seleccionado);
		imageViewSeleccionado.setFitWidth(35);
		imageViewSeleccionado.setPreserveRatio(true);
		imageViewSeleccionado.setSmooth(true);
		imageViewSeleccionado.setCache(true);
		getChildren().add(imageViewSeleccionado);
	}

	public void ocultarSeleccionable() {
		try {
			getChildren().remove(2);
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
	}
	
	public void esperarAtaque(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Ofensiva ofensiva, Posicion posicion) {
		for (VistaPosicionable vistaPosicionable: vistasPosicionables) {
			vistaPosicionable.setearClickListener(new CeldaAtacable(contenedor, ofensiva, edificio, posicion));
			vistaPosicionable.setOnMouseEntered(e-> {
				Image cursor = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Cursors/SelecAtaque.png");
				vistaPosicionable.cursorProperty().set(new ImageCursor(cursor));
			});
			vistaPosicionable.setOnMouseExited(e-> {
				vistaPosicionable.cursorProperty().set(Cursor.DEFAULT);
			});
		}
	}

	public void esperarConstruccionReparacion(Aldeano aldeano, ContenedorPantallaDeJuego contenedorPantallaDeJuego){
		for (VistaPosicionable vistaPosicionable: vistasPosicionables) {
			vistaPosicionable.setearClickListener(new CeldaConstruirReparar(contenedorPantallaDeJuego, edificio, aldeano));
			vistaPosicionable.setOnMouseEntered(e-> {
				Image cursor = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Cursors/repair.png");
				vistaPosicionable.cursorProperty().set(new ImageCursor(cursor));
			});
			vistaPosicionable.setOnMouseExited(e-> {
				vistaPosicionable.cursorProperty().set(Cursor.DEFAULT);
			});
		}
	}

	public Posicionable getPosicionable() {
		return this.edificio;
	}
	
	public void setearClickListener(EventHandler<MouseEvent> evento) {
		this.setOnMouseClicked(evento);
	}
}
