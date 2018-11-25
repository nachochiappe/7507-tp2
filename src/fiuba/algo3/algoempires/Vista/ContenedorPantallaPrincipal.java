package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Controlador.BotonJugarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ContenedorPantallaPrincipal extends VBox {

    Stage stage;

    public ContenedorPantallaPrincipal(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(80);
        this.setPadding(new Insets(80));
        Image imagen = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Portada2.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setMaxWidth(140);

        Label etiqueta = new Label();
        //etiqueta.setFont(Font.font("Baskerville Old Face",80 ));
        etiqueta.setText("Algo" +"\n"+  "Empires");
        etiqueta.setStyle("-fx-font-family: Castellar;-fx-text-fill: #b30000; -fx-font-weight: 900; -fx-font-size: 120; -fx-text-alignment: center");
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(6.0);
        dropShadow.setOffsetY(6.0);
        dropShadow.setColor(Color.web("#4A0000"));
        etiqueta.setEffect(dropShadow);
        BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarHandler);

        TextField nombreJugador1 = new TextField();
        nombreJugador1.setText("Nombre de Jugador1");
        nombreJugador1.setMaxWidth(140);
        TextField nombreJugador2 = new TextField();
        nombreJugador2.setText("Nombre de Jugador2");
        nombreJugador2.setMaxWidth(140);
        
        this.getChildren().addAll(etiqueta,nombreJugador1, nombreJugador2, botonJugar);
    }

}