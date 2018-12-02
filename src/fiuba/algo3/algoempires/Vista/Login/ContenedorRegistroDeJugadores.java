package fiuba.algo3.algoempires.Vista.Login;

import fiuba.algo3.algoempires.Controlador.PantallaLogin.BotonCancelarEventHandler;
import fiuba.algo3.algoempires.Controlador.PantallaLogin.BotonComenzarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorRegistroDeJugadores {

    public void display(Stage rootStage) {
        Stage stage = new Stage();
        stage.initOwner(rootStage);
        stage.setTitle("Registro de jugadores");
        BorderPane borderPane = new BorderPane();

        Label header = new Label();
        header.setText("Ingrese el nombre de los jugadores");
        header.getStyleClass().add("header");
        header.setPadding(new Insets(20,0,20,0));

        VBox usuarios = new VBox();

        Label inputLabel1 = new Label();
        inputLabel1.setText("Nombre del jugador 1:");
        inputLabel1.getStyleClass().add("label");

        Label inputLabel2 = new Label();
        inputLabel2.setText("Nombre del jugador 2:");
        inputLabel2.getStyleClass().add("label");

        TextField nombreJugador1 = new TextField();
        nombreJugador1.setPromptText("Ingrese un nombre");
        nombreJugador1.setMaxWidth(300);
        nombreJugador1.getStyleClass().add("textField");
        TextField nombreJugador2 = new TextField();
        nombreJugador2.setPromptText("Ingrese un nombre");
        nombreJugador2.setMaxWidth(300);
        nombreJugador2.getStyleClass().add("textField");
        usuarios.setSpacing(20);
        usuarios.setPadding(new Insets(20));
        usuarios.getChildren().addAll(inputLabel1, nombreJugador1, inputLabel2, nombreJugador2);
        usuarios.setAlignment(Pos.CENTER);

        Button botonCancelar = new Button();
        botonCancelar.setText("Cancelar");
        botonCancelar.setPrefWidth(150);
        botonCancelar.setOnAction(new BotonCancelarEventHandler(stage));

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setPrefWidth(200);
        botonJugar.setOnAction(new BotonComenzarEventHandler(stage, rootStage, usuarios));

        HBox botonera = new HBox();
        botonera.setSpacing(20);
        botonera.getChildren().addAll(botonCancelar, botonJugar);
        botonera.setPadding(new Insets(0,0,30,0));
        botonera.setAlignment(Pos.BOTTOM_CENTER);

        BorderPane.setAlignment(header, Pos.TOP_CENTER);
        borderPane.setTop(header);
        borderPane.setCenter(usuarios);
        borderPane.setBottom(botonera);
        Scene scene = new Scene(borderPane, 600, 600);
        scene.getStylesheets().add("file:src/fiuba/algo3/algoempires/Vista/Login/RegistroDeJugadores.css");
        stage.setScene(scene);
        borderPane.requestFocus();
        stage.setFullScreen(false);
        stage.showAndWait();
    }

}
