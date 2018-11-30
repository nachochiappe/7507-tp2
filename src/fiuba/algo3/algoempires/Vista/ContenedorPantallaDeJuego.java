package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Controlador.VistaAldeanoEventHandler;
import fiuba.algo3.algoempires.Model.AlgoEmpires;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import pruebas.PruebasGridPane;



public class ContenedorPantallaDeJuego extends BorderPane {

    BarraDeMenu menuBar;
//    VistaMapa vistaMapa;
    Canvas canvasCentral;
    VistaMapa contenedorCentral;
    AlgoEmpires algoEmpires;
    VBox statsJugador ;

    public ContenedorPantallaDeJuego(Stage stage, AlgoEmpires algoEmpires) {
        this.algoEmpires = algoEmpires;
        this.setMenu(stage);
        this.setCentro();
//        this.setBotonera(robot);

        Button button = new Button();
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
        this.setLeft(button);

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
/*
        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(0);
        contenedorCentral.setPadding(new Insets(25));
        Image imagenMapa = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Mapa1.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagenMapa, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));
*/
        this.setCenter(contenedorCentral);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}