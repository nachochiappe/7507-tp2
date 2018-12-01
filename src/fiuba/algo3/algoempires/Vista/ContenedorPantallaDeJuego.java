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
    	
    	StackPane stackPane = new StackPane();
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
		stackPane.getChildren().addAll(imageViewPiso, imageViewAldeano);
		imageViewAldeano.setOnMouseClicked(e -> mostrarMenuDeOpciones());
		gridPane.add(stackPane, 10, 10);
    	
    	this.setCenter(gridPane);

    	/*
        Canvas canvasCentral = new Canvas(640, 640);
        contenedorCentral = new VistaMapa();
// ------ Esto va de prueba ---------- 
        
        contenedorCentral.setAlignment(Pos.CENTER);
        Aldeano aldeano = new Aldeano(new Jugador("rama"), new Posicion(0,0));
        VistaAldeano vistaAldeano = new VistaAldeano(aldeano);
//        vistaMapa.agregar(vistaAldeano);
        VistaAldeanoEventHandler vistaAldeanoEventHandler = new VistaAldeanoEventHandler(aldeano, vistaAldeano);
        contenedorCentral.agregar(vistaAldeano);

        Aldeano aldeano2 = new Aldeano(new Jugador("rama"), new Posicion(19,19));
        VistaAldeano vistaAldeano2 = new VistaAldeano(aldeano2);

// -------- hasta aca -------------------------

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(0);
        contenedorCentral.setPadding(new Insets(25));
        Image imagenMapa = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Mapa1.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagenMapa, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
        */
    }

    private void mostrarMenuDeOpciones() {
		// acá debería chequear si la unidad pertenece al equipo del jugador
    	// si no es suya, tiene que mostrar solo la vida y no el menú de opciones
    	this.unitVBox = new VBox(20);
    	this.unitVBox.setAlignment(Pos.TOP_CENTER);
    	this.unitVBox.setPadding(new Insets(20));
    	
    	Image imagenUnidad = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Aldeano/AldeanoI.png");
		ImageView imageView = new ImageView();
		imageView.setImage(imagenUnidad);
		imageView.setFitWidth(50);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		imageView.setCache(true);
		this.unitVBox.getChildren().add(imageView);
		
		Label nombreUnidad = new Label("Aldeano");
		Label vidaUnidad = new Label("Vida: ");
		this.unitVBox.getChildren().addAll(nombreUnidad, vidaUnidad);
		
		VBox accionesVBox = new VBox(20);
    	accionesVBox.setPadding(new Insets(20));
    	accionesVBox.setAlignment(Pos.TOP_CENTER);
    	Button botonMoverUnidad = new Button("Mover Unidad");
    	Button botonConstruirPlazaCentral = new Button("Construir Plaza Central");
    	Button botonConstruirCuartel = new Button("Construir Cuartel");
    	Button botonReparar = new Button("Reparar");
    	accionesVBox.getChildren().addAll(botonMoverUnidad, botonConstruirPlazaCentral, botonConstruirCuartel, botonReparar);
    	this.unitVBox.getChildren().add(accionesVBox);
    	this.leftBorderPane.setCenter(this.unitVBox);
	}

	public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}