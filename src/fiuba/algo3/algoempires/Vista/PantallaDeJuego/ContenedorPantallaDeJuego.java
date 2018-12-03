package fiuba.algo3.algoempires.Vista.PantallaDeJuego;

import java.util.List;

import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.*;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.JugadorHUD.JugadorHUD;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class ContenedorPantallaDeJuego extends BorderPane {

	public BarraDeMenu menuBar;

    public AlgoEmpires algoEmpires;
	public VistaTablero vistaTablero;
	public BorderPane leftBorderPane;
	public VBox unitVBox;
	public JugadorHUD jugadorHUD;
	public SeleccionableHUD seleccionableHUD;

    public ContenedorPantallaDeJuego(Stage stage, AlgoEmpires algoEmpires) {
        this.algoEmpires = algoEmpires;
        this.vistaTablero = new VistaTablero();
        vistaTablero.setAlignment(Pos.CENTER);
        this.leftBorderPane = new BorderPane();
        leftBorderPane.setPadding(new Insets(20));
        this.setMenu(stage);
        this.setCentro();
//        this.setBotonera(robot);
		jugadorHUD = new JugadorHUD(this);
        this.setLeft(leftBorderPane);


        this.setRight(jugadorHUD);
    }

/*
    private void setBotonera(Robot robot) {

        Button botonMover = new Button();
        botonMover.setText("Mover");
        BotonMoverHandler moveButtonHandler = new BotonMoverHandler(vistaRobot, robot);
        botonMover.setOnAction(moveButtonHandler);

        Button botonDireccion = new Button();
        botonDireccion.setText("Cambiar direccion");
        BotonDireccionHandler directionButtonHandler = new BotonDireccionHandler(robot);
        botonDireccion.setOnAction(directionButtonHandler);

        VBox contenedorVertical = new VBox(botonMover, botonDireccion);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);

    }
*/
    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
    private void setCentro() {
    	
    	Tablero tablero = Tablero.getInstance();
    	
    	this.vistaTablero.iniciarTablero();
    	
    	/*
    	List<Posicionable> posicionables = tablero.obtenerTodosLosPosicionables();
    	for (Posicionable posicionable : posicionables) {
    		StackPane stackPane = new StackPane();
			Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
			ImageView imageView = new ImageView();
			imageView.setImage(pisoVacio);
			imageView.setFitWidth(40);
			imageView.setPreserveRatio(true);
			imageView.setSmooth(true);
			imageView.setCache(true);
			Image sprite = posicionable.getSprite();
			ImageView imageViewSprite = new ImageView();
			imageViewSprite.setImage(sprite);
			imageViewSprite.setFitWidth(40);
			imageViewSprite.setPreserveRatio(true);
			imageViewSprite.setSmooth(true);
			imageViewSprite.setCache(true);
			stackPane.getChildren().addAll(imageView, imageViewSprite);
            this.add(stackPane, j, i);
    	}
    	*/
	
    	/*
    	//UNIDADES DE PRUEBA (Con posicion harcodeada)
    	Unidad aldeano = new Aldeano(new Jugador("UNO"),new Posicion(10,10));
    	Unidad espadachin = new Aldeano(new Jugador("UNO"),new Posicion(10,11));
    	Unidad arquero = new Aldeano(new Jugador("UNO"),new Posicion(10,12));
    	Unidad armaDeAsedio = new Aldeano(new Jugador("UNO"),new Posicion(10,13));
    	VistaAldeano vistaAldeano = new VistaAldeano(aldeano, unitVBox,leftBorderPane);
    	this.vistaTablero.agregar(vistaAldeano);
    	VistaEspadachin vistaEspadachin = new VistaEspadachin(espadachin, unitVBox,leftBorderPane);
    	this.vistaTablero.agregar(vistaEspadachin);
    	VistaArquero vistaArquero = new VistaArquero(arquero, unitVBox,leftBorderPane);
    	this.vistaTablero.agregar(vistaArquero);
    	VistaArmaDeAsedio vistaArmaDeAsedio = new VistaArmaDeAsedio(armaDeAsedio, unitVBox,leftBorderPane);
    	this.vistaTablero.agregar(vistaArmaDeAsedio);

    	
		//HARDCODEO EDIFICIOS DE PRUEBA
		//CASTILLO
    	Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
		ImageView imageViewPiso = new ImageView();
		imageViewPiso.setImage(pisoVacio);
		imageViewPiso.setFitWidth(40);
		imageViewPiso.setPreserveRatio(true);
		imageViewPiso.setSmooth(true);
		imageViewPiso.setCache(true);
		StackPane stackPaneCastillo1 = new StackPane();
		StackPane stackPaneCastillo2 = new StackPane();
		StackPane stackPaneCastillo3 = new StackPane();
		StackPane stackPaneCastillo4 = new StackPane();
		Image castilloOriginal = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/Castillo/CastilloConstruido.png");
		PixelReader castillo = castilloOriginal.getPixelReader();
		WritableImage castilloParte1 = new WritableImage(castillo, 0, 0, 64, 64);
		WritableImage castilloParte2 = new WritableImage(castillo, 64, 0, 64, 64);
		WritableImage castilloParte3 = new WritableImage(castillo, 0, 64, 64, 64);
		WritableImage castilloParte4 = new WritableImage(castillo, 64, 64, 64, 64);
		ImageView imageViewCastillo1 = new ImageView();
		imageViewCastillo1.setImage(castilloParte1);
		imageViewCastillo1.setFitWidth(40);
		imageViewCastillo1.setPreserveRatio(true);
		imageViewCastillo1.setSmooth(true);
		imageViewCastillo1.setCache(true);
		stackPaneCastillo1.getChildren().addAll(imageViewPiso, imageViewCastillo1);
		vistaTablero.add(stackPaneCastillo1, 0, 0);
		ImageView imageViewCastillo2 = new ImageView();
		imageViewCastillo2.setImage(castilloParte2);
		imageViewCastillo2.setFitWidth(40);
		imageViewCastillo2.setPreserveRatio(true);
		imageViewCastillo2.setSmooth(true);
		imageViewCastillo2.setCache(true);
		stackPaneCastillo2.getChildren().addAll(imageViewPiso, imageViewCastillo2);
		vistaTablero.add(stackPaneCastillo2, 1, 0);
		ImageView imageViewCastillo3 = new ImageView();
		imageViewCastillo3.setImage(castilloParte3);
		imageViewCastillo3.setFitWidth(40);
		imageViewCastillo3.setPreserveRatio(true);
		imageViewCastillo3.setSmooth(true);
		imageViewCastillo3.setCache(true);
		stackPaneCastillo3.getChildren().addAll(imageViewPiso, imageViewCastillo3);
		vistaTablero.add(stackPaneCastillo3, 0, 1);
		ImageView imageViewCastillo4 = new ImageView();
		imageViewCastillo4.setImage(castilloParte4);
		imageViewCastillo4.setFitWidth(40);
		imageViewCastillo4.setPreserveRatio(true);
		imageViewCastillo4.setSmooth(true);
		imageViewCastillo4.setCache(true);
		stackPaneCastillo4.getChildren().addAll(imageViewPiso, imageViewCastillo4);
		vistaTablero.add(stackPaneCastillo4, 1, 1);
		//imageViewCastillo.setOnMouseClicked(e -> mostrarMenuDeCastillo());
		 */

    	this.setCenter(vistaTablero);
    }


 

    
	public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}