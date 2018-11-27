package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Controlador.PantallaPrincipal.BotonJugarEventHandler;
import fiuba.algo3.algoempires.Controlador.PantallaPrincipal.BotonReglasEventHandler;
import fiuba.algo3.algoempires.Controlador.PantallaPrincipal.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotoneraMenuPrincipal extends VBox {

    Stage stage;

    public BotoneraMenuPrincipal(Stage stage) {
        this.stage = stage;
        this.setSpacing(40);
        this.setPadding(new Insets(20, 0, 0, 0));
        this.setAlignment(Pos.BASELINE_CENTER);
        //BOTÓN JUGAR--------------//
        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setMaxWidth(250);
        botonJugar.setOnAction(new BotonJugarEventHandler(stage));

        //BOTÓN JUGAR--------------//


        //BOTÓN REGLAS--------------//
        Button botonReglas = new Button();
        botonReglas.setText("Reglas");
        botonReglas.setMaxWidth(250);
        botonReglas.setOnAction(new BotonReglasEventHandler(stage));
        //BOTÓN REGLAS--------------//

        //BOTÓN SALIR--------------//
        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setMaxWidth(250);
        botonSalir.setOnAction(new BotonSalirEventHandler());

        //BOTÓN SALIR--------------//

        this.getChildren().addAll(botonJugar, botonReglas, botonSalir);
    }
}
