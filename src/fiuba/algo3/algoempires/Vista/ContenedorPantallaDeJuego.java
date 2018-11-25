package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ContenedorPantallaDeJuego extends BorderPane {

    BarraDeMenu menuBar;
//    VistaMapa vistaMapa;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorPantallaDeJuego(Stage stage) {
        this.setMenu(stage);
        this.setCentro();
//        this.setBotonera(robot);
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

        canvasCentral = new Canvas(640, 640);
// ------ Esto va de prueba ---------- 
        Aldeano aldeano = new Aldeano(new Jugador("rama"), new Posicion(5,5));
        VistaAldeano vistaAldeano = new VistaAldeano(aldeano, canvasCentral);
        vistaAldeano.dibujar();
// -------- hasta aca -------------------------
        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(0);
        contenedorCentral.setPadding(new Insets(25));
        Image imagenMapa = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Mapa1.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagenMapa, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}