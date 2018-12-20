package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import fiuba.algo3.algoempires.Controlador.Tablero.Celdas.CeldaAtacable;
import fiuba.algo3.algoempires.Controlador.Tablero.Celdas.CeldaCrearUnidad;
import fiuba.algo3.algoempires.Controlador.Tablero.Celdas.ClickPosicionableEventHandler;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.Alerts.ContenedorAlerta;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.List;

public  class VistaUnidad extends  VistaPosicionable{
	public ContenedorPantallaDeJuego contenedor;
    public Unidad unidad;
    protected VBox unitVBox;
    protected Image imagenUnidad;
    public Jugador jugadorActual;
	public BorderPane borderPane;

	public VistaUnidad(ContenedorPantallaDeJuego _contenedor, Unidad unidad, Jugador jugadorActual) {
		this.contenedor = _contenedor;
		this.unidad = unidad;
		this.unitVBox = this.contenedor.unitVBox;
		this.borderPane = this.contenedor.leftBorderPane;
		this.jugadorActual = jugadorActual;
		this.inicializar();
	}



	public int getPosX() {
    	return unidad.getPosicion().getPosicionX();
    }
    
    public int getPosY() {
    	return unidad.getPosicion().getPosicionY();
    }

    @Override
    public void inicializar() {
    	Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
		ImageView imageViewPiso = new ImageView();
		imageViewPiso.setImage(pisoVacio);
		imageViewPiso.setFitWidth(40);
		imageViewPiso.setPreserveRatio(true);
		imageViewPiso.setSmooth(true);
		imageViewPiso.setCache(true);
		ImageView imageViewUnidad = new ImageView();
		imageViewUnidad.setImage(this.unidad.getSprite());

		imageViewUnidad.setFitWidth(40);
		imageViewUnidad.setPreserveRatio(true);
		imageViewUnidad.setSmooth(true);
		imageViewUnidad.setCache(true);
		this.getChildren().addAll(imageViewPiso, imageViewUnidad);
		this.setearClickListener(new ClickPosicionableEventHandler(this));

		this.setOnMouseEntered(event -> {
			Image seleccionado = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/selec.png");
			ImageView imageViewSeleccionado = new ImageView();
			imageViewSeleccionado.setImage(seleccionado);
			imageViewSeleccionado.setFitWidth(40);
			imageViewSeleccionado.setPreserveRatio(true);
			imageViewSeleccionado.setSmooth(true);
			imageViewSeleccionado.setCache(true);
			getChildren().add(imageViewSeleccionado);
			cursorProperty().set(Cursor.HAND);
		});
		this.setOnMouseExited(event -> {
			getChildren().remove(2);
			cursorProperty().set(Cursor.DEFAULT);
		});
    }

    @Override
    public void agregarATablero(VistaTablero vistaTablero, Posicionable _unidad, int i, int j) {
    	Unidad unidad = (Unidad) _unidad;
    	vistaTablero.add(this, unidad.getPosicion().getPosicionX(), unidad.getPosicion().getPosicionY());
    }

	@Override
	public Posicion getPosicion() {
		return unidad.getPosicion();
	}



	public void setearClickListener(EventHandler<MouseEvent> eventEventHandler) {
		this.setOnMouseClicked(eventEventHandler);
	}

	@Override
	public void esperarConstruccion(ContenedorPantallaDeJuego contenedor, Aldeano aldeano, Edificio edificio, Posicion posicion, List<VistaPosicionable> vistaPosicionables) {
		this.setearClickListener(event -> {
			ContenedorAlerta contenedorAlerta = new ContenedorAlerta();
			contenedorAlerta.display(contenedor.rootStage, "No puede construir aquí");
		});
	}



	@Override
	public void esperarCreacionUnidad(ContenedorPantallaDeJuego contenedor, Edificio edificio, Unidad unidad,
			Posicion posicion) {
		this.setearClickListener(event -> {
			ContenedorAlerta contenedorAlerta = new ContenedorAlerta();
			contenedorAlerta.display(contenedor.rootStage, "No puede crear aquí");
		});
		
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



	@Override
	public void esperarAtaque(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Ofensiva ofensiva, Posicion posicion) {
		this.setearClickListener(new CeldaAtacable(contenedor, ofensiva, unidad, posicion));
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
			this.getChildren().remove(2);
			cursorProperty().set(Cursor.DEFAULT);
		});
		
	}

	@Override
	public void esperarConstruccionReparacion(Aldeano aldeano, ContenedorPantallaDeJuego contenedorPantallaDeJuego) {
		this.setearClickListener(event -> {
			ContenedorAlerta contenedorAlerta = new ContenedorAlerta();
			contenedorAlerta.display(contenedor.rootStage, "Edificio inválido");
		});
	}

}
