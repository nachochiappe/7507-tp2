package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Controlador.VistaAldeanoEventHandler;
import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import pruebas.PruebasGridPane;



public class ContenedorPantallaDeJuego extends BorderPane {

	private BarraDeMenu menuBar;
//    VistaMapa vistaMapa;
    //private Canvas canvasCentral;
    //private VistaMapa contenedorCentral;
    private AlgoEmpires algoEmpires;
    private VBox statsJugador ;
    private GridPane gridPane;
    private BorderPane leftBorderPane;
    private VBox unitVBox;

    public ContenedorPantallaDeJuego(Stage stage, AlgoEmpires algoEmpires) {
        this.algoEmpires = algoEmpires;
        this.gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        this.leftBorderPane = new BorderPane();
        leftBorderPane.setPadding(new Insets(20));
        this.setMenu(stage);
        this.setCentro();
//        this.setBotonera(robot);

        Button button = new Button();
        button.setAlignment(Pos.TOP_CENTER);
        button.setPadding(new Insets(20));
        button.setText("Terminar Turno");
        button.setOnAction(e -> {
            algoEmpires.pasarTurno();
            statsJugador = new VBox();
            statsJugador.setSpacing(20);
            statsJugador.setPadding(new Insets(20));
            Label nombreJugador = new Label();
            nombreJugador.setText(algoEmpires.getJugadorActual().getNombre());
            Label oroJugador = new Label();
            oroJugador.setText(String.valueOf(algoEmpires.getJugadorActual().getOro()));
            statsJugador.getChildren().addAll(nombreJugador, oroJugador);
            this.setRight(statsJugador);
        });
        this.leftBorderPane.setTop(button);
        this.setLeft(leftBorderPane);

        statsJugador = new VBox();
        statsJugador.setSpacing(20);
        statsJugador.setPadding(new Insets(20));
        Label nombreJugador = new Label();
        nombreJugador.setText(algoEmpires.getJugadorActual().getNombre());
        Label oroJugador = new Label();
        oroJugador.setText(String.valueOf(algoEmpires.getJugadorActual().getOro()));
        statsJugador.getChildren().addAll(nombreJugador, oroJugador);

        this.setRight(statsJugador);
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
    	
    	for (int i = 0; i < tablero.getAncho(); i++) {
    		for (int j = 0; j < tablero.getAlto(); j++) {
    			StackPane stackPane = new StackPane();
    			Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
    			ImageView imageView = new ImageView();
    			imageView.setImage(pisoVacio);
    			imageView.setFitWidth(40);
    			imageView.setPreserveRatio(true);
    			imageView.setSmooth(true);
    			imageView.setCache(true);
    			stackPane.getChildren().add(imageView);
                gridPane.add(stackPane, j, i);
    		}
    	}
    	
    	//HARDCODEO UNIDADES DE PRUEBA
    	//ALDEANO
    	StackPane stackPaneAldeano = new StackPane();
    	Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
		ImageView imageViewPiso = new ImageView();
		imageViewPiso.setImage(pisoVacio);
		imageViewPiso.setFitWidth(40);
		imageViewPiso.setPreserveRatio(true);
		imageViewPiso.setSmooth(true);
		imageViewPiso.setCache(true);
    	Image aldeano = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Aldeano/AldeanoI.png");
		ImageView imageViewAldeano = new ImageView();
		imageViewAldeano.setImage(aldeano);
		imageViewAldeano.setFitWidth(40);
		imageViewAldeano.setPreserveRatio(true);
		imageViewAldeano.setSmooth(true);
		imageViewAldeano.setCache(true);
		stackPaneAldeano.getChildren().addAll(imageViewPiso, imageViewAldeano);
		imageViewAldeano.setOnMouseClicked(e -> mostrarMenuDeAldeano());
		gridPane.add(stackPaneAldeano, 10, 10);
		
    	//ARQUERO
    	StackPane stackPaneArquero = new StackPane();
		Image arquero = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Arquero/ArqueroS.png");
		ImageView imageViewArquero = new ImageView();
		imageViewArquero.setImage(arquero);
		imageViewArquero.setFitWidth(40);
		imageViewArquero.setPreserveRatio(true);
		imageViewArquero.setSmooth(true);
		imageViewArquero.setCache(true);
		stackPaneArquero.getChildren().addAll(imageViewPiso, imageViewArquero);
		imageViewArquero.setOnMouseClicked(e -> mostrarMenuDeArquero());
		gridPane.add(stackPaneArquero, 11, 11);
		
    	//ESPADACHIN
    	StackPane stackPaneEspadachin = new StackPane();
		Image espadachin = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Espadachin/EspadachinS.png");
		ImageView imageViewEspadachin = new ImageView();
		imageViewEspadachin.setImage(espadachin);
		imageViewEspadachin.setFitWidth(40);
		imageViewEspadachin.setPreserveRatio(true);
		imageViewEspadachin.setSmooth(true);
		imageViewEspadachin.setCache(true);
		stackPaneEspadachin.getChildren().addAll(imageViewPiso, imageViewEspadachin);
		imageViewEspadachin.setOnMouseClicked(e -> mostrarMenuDeEspadachin());
		gridPane.add(stackPaneEspadachin, 12, 12);
    	
		//HARDCODEO EDIFICIOS DE PRUEBA
		//CASTILLO
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
		gridPane.add(stackPaneCastillo1, 0, 0);
		ImageView imageViewCastillo2 = new ImageView();
		imageViewCastillo2.setImage(castilloParte2);
		imageViewCastillo2.setFitWidth(40);
		imageViewCastillo2.setPreserveRatio(true);
		imageViewCastillo2.setSmooth(true);
		imageViewCastillo2.setCache(true);
		stackPaneCastillo2.getChildren().addAll(imageViewPiso, imageViewCastillo2);
		gridPane.add(stackPaneCastillo2, 1, 0);
		ImageView imageViewCastillo3 = new ImageView();
		imageViewCastillo3.setImage(castilloParte3);
		imageViewCastillo3.setFitWidth(40);
		imageViewCastillo3.setPreserveRatio(true);
		imageViewCastillo3.setSmooth(true);
		imageViewCastillo3.setCache(true);
		stackPaneCastillo3.getChildren().addAll(imageViewPiso, imageViewCastillo3);
		gridPane.add(stackPaneCastillo3, 0, 1);
		ImageView imageViewCastillo4 = new ImageView();
		imageViewCastillo4.setImage(castilloParte4);
		imageViewCastillo4.setFitWidth(40);
		imageViewCastillo4.setPreserveRatio(true);
		imageViewCastillo4.setSmooth(true);
		imageViewCastillo4.setCache(true);
		stackPaneCastillo4.getChildren().addAll(imageViewPiso, imageViewCastillo4);
		gridPane.add(stackPaneCastillo4, 1, 1);
		//imageViewCastillo.setOnMouseClicked(e -> mostrarMenuDeCastillo());
		
    	this.setCenter(gridPane);
    }

    private void mostrarMenuDeAldeano() {
		// acá debería chequear si la unidad pertenece al equipo del jugador
    	// si no es suya, tiene que mostrar solo la vida y no el menú de opciones
    	
    	Image imagenUnidad = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Aldeano/AldeanoI.png");
		ImageView imageView = new ImageView();
		imageView.setImage(imagenUnidad);
		Button botonMoverUnidad = new Button("Mover Unidad");
    	Button botonConstruirPlazaCentral = new Button("Construir Plaza Central");
    	Button botonConstruirCuartel = new Button("Construir Cuartel");
    	Button botonReparar = new Button("Reparar");
    	mostrarMenu(imageView, "Aldeano", botonMoverUnidad, botonConstruirPlazaCentral, botonConstruirCuartel, botonReparar);
	}
    
    private void mostrarMenuDeEspadachin() {
		// acá debería chequear si la unidad pertenece al equipo del jugador
    	// si no es suya, tiene que mostrar solo la vida y no el menú de opciones
    	
    	Image imagenUnidad = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Espadachin/EspadachinS.png");
    	ImageView imageView = new ImageView();
		imageView.setImage(imagenUnidad);
		Button botonMoverUnidad = new Button("Mover Unidad");
    	Button botonAtacar = new Button("Atacar");
		mostrarMenu(imageView, "Espadachin", botonMoverUnidad, botonAtacar);
	}
    
    private void mostrarMenuDeArquero() {
		// acá debería chequear si la unidad pertenece al equipo del jugador
    	// si no es suya, tiene que mostrar solo la vida y no el menú de opciones
    	
    	Image imagenUnidad = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Arquero/ArqueroS.png");
		ImageView imageView = new ImageView();
		imageView.setImage(imagenUnidad);
		Button botonMoverUnidad = new Button("Mover Unidad");
    	Button botonAtacar = new Button("Atacar");
		mostrarMenu(imageView, "Arquero", botonMoverUnidad, botonAtacar);
	}

    private void mostrarMenu(ImageView imageView, String _nombre, Button...buttons) {
    	this.unitVBox = new VBox(20);
    	this.unitVBox.setAlignment(Pos.TOP_CENTER);
    	this.unitVBox.setPadding(new Insets(20));
		imageView.setFitWidth(50);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		imageView.setCache(true);
		this.unitVBox.getChildren().add(imageView);
		
		Label nombre = new Label(_nombre);
		Label vida = new Label("Vida: ");
		this.unitVBox.getChildren().addAll(nombre, vida);
		
		VBox accionesVBox = new VBox(20);
    	accionesVBox.setPadding(new Insets(20));
    	accionesVBox.setAlignment(Pos.TOP_CENTER);
    	for (Button button : buttons) {
    		accionesVBox.getChildren().add(button);
		}
    	this.unitVBox.getChildren().add(accionesVBox);
    	this.leftBorderPane.setCenter(this.unitVBox);
    }
    
	public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}