package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Controlador.PantallaPrincipal.BotonJugarEventHandler;
import fiuba.algo3.algoempires.Controlador.PantallaPrincipal.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotoneraMenuPrincipal extends VBox {

    Stage stage;

    public BotoneraMenuPrincipal(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.setSpacing(50);
        this.setPadding(new Insets(20));

        //BOTÓN JUGAR--------------//
        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setMaxWidth(140);
        BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarHandler);
        //BOTÓN JUGAR--------------//


        //BOTÓN REGLAS--------------//
        Button botonReglas = new Button();
        botonReglas.setText("Reglas");
        botonReglas.setMaxWidth(140);
        //BOTÓN REGLAS--------------//

        //BOTÓN SALIR--------------//
        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setMaxWidth(140);
        botonSalir.setOnAction(new BotonSalirEventHandler());
        //BOTÓN SALIR--------------//


        this.getChildren().addAll(botonJugar, botonReglas, botonSalir);
    }
}
