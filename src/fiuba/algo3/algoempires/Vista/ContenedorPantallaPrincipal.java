package fiuba.algo3.algoempires.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ContenedorPantallaPrincipal extends StackPane {

    Stage stage;

    public ContenedorPantallaPrincipal(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(80));

        //IMAGEN DE FONDO-------//
        Image imagen = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Portada2.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        //IMAGEN DE FONDO-------//


        //LABEL MENU PRINCIPAL-------//
        Label etiqueta = new Label();
        etiqueta.setText("Algo" +"\n"+  "Empires");
        etiqueta.setStyle("-fx-font-family: Castellar;-fx-text-fill: #b30000; -fx-font-weight: 900; -fx-font-size: 120; -fx-text-alignment: center");
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(6.0);
        dropShadow.setOffsetY(6.0);
        dropShadow.setColor(Color.web("#4A0000"));
        etiqueta.setEffect(dropShadow);
        etiqueta.setAlignment(Pos.TOP_CENTER);
        //LABEL MENU PRINCIPAL-------//

        VBox botonora = new BotoneraMenuPrincipal(stage, proximaEscena);
        botonora.setAlignment(Pos.BOTTOM_CENTER);


        TextField nombreJugador1 = new TextField();
        nombreJugador1.setText("Nombre de Jugador1");
        nombreJugador1.setMaxWidth(140);
        TextField nombreJugador2 = new TextField();
        nombreJugador2.setText("Nombre de Jugador2");
        nombreJugador2.setMaxWidth(140);
        
        //this.getChildren().addAll(etiqueta,nombreJugador1, nombreJugador2, botonora);
        this.getChildren().addAll(etiqueta,botonora);
    }

}