package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import fiuba.algo3.algoempires.Controlador.Tablero.Celdas.CeldaCrearEdificio;
import fiuba.algo3.algoempires.Controlador.Tablero.Celdas.CeldaCrearUnidad;
import fiuba.algo3.algoempires.Controlador.Tablero.Celdas.LugarVacioEventHandler;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.LugarVacio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VistaLugarVacio extends VistaPosicionable{
	
	private Image pisoVacio;
	ContenedorPantallaDeJuego contenedor;
	LugarVacio lugarVacio;
	
	public VistaLugarVacio(ContenedorPantallaDeJuego contenedor, LugarVacio lugarVacio) {
		pisoVacio  = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
		this.contenedor = contenedor;
		this.lugarVacio = lugarVacio;
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
		imageViewPiso.setOnMouseClicked(new LugarVacioEventHandler(this.contenedor));

	}

	@Override
    public void agregarATablero(VistaTablero vistaTablero, Posicionable posicionable, int i, int j) {
    	vistaTablero.add(this, i, j);
    }

	@Override
	public Posicion getPosicion() {
		return lugarVacio.getPosicion();
	}

	public void setearClickListener(EventHandler<MouseEvent> eventEventHandler) {
		this.setOnMouseClicked(eventEventHandler);
	}

	@Override
	public void esperarConstruccion(ContenedorPantallaDeJuego contenedor, Aldeano aldeano, Edificio edificio, Posicion posicion) {
		Image seleccionado = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/selec.png");
		ImageView imageViewSeleccionado = new ImageView();
		imageViewSeleccionado.setImage(seleccionado);
		imageViewSeleccionado.setFitWidth(40);
		imageViewSeleccionado.setPreserveRatio(true);
		imageViewSeleccionado.setSmooth(true);
		imageViewSeleccionado.setCache(true);
		getChildren().add(imageViewSeleccionado);
		this.setearClickListener(new CeldaCrearEdificio(contenedor, aldeano, edificio, posicion));
		this.setOnMouseEntered(event -> {
			Image sprite =  new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Cursors/build.png");
			ImageCursor imageCursor = new ImageCursor(sprite);
			cursorProperty().set(imageCursor);
		});
		this.setOnMouseExited(event -> {
			cursorProperty().set(Cursor.DEFAULT);
		});
	}


	@Override
	public void esperarCreacionUnidad(ContenedorPantallaDeJuego contenedor, Edificio edificio, Unidad unidad, Posicion posicion) {
		this.setearClickListener(new CeldaCrearUnidad(contenedor, edificio, unidad, posicion));
		this.setOnMouseEntered(event -> {
			Image seleccionado = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/selec.png");
			ImageView imageViewSeleccionado = new ImageView();
			imageViewSeleccionado.setImage(seleccionado);
			imageViewSeleccionado.setFitWidth(40);
			imageViewSeleccionado.setPreserveRatio(true);
			imageViewSeleccionado.setSmooth(true);
			imageViewSeleccionado.setCache(true);
			getChildren().add(imageViewSeleccionado);
			Image sprite =  new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Cursors/build.png");
			ImageCursor imageCursor = new ImageCursor(sprite);
			cursorProperty().set(imageCursor);
		});
		this.setOnMouseExited(event -> {
			getChildren().remove(1);
			cursorProperty().set(Cursor.DEFAULT);
		});
		
	}
	
	


}
