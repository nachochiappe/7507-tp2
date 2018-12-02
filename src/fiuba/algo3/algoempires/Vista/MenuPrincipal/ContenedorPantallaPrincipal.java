package fiuba.algo3.algoempires.Vista.MenuPrincipal;

import fiuba.algo3.algoempires.Vista.MenuPrincipal.BotoneraMenuPrincipal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ContenedorPantallaPrincipal extends BorderPane {

    Stage stage;

    public ContenedorPantallaPrincipal(Stage stage) {

        super();

        this.stage = stage;

        this.setPadding(new Insets(20,0,30,0));

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

        //LABEL MENU PRINCIPAL-------//

        VBox botonora = new BotoneraMenuPrincipal(stage);
        botonora.setAlignment(Pos.BOTTOM_CENTER);

        this.setBottom(botonora);
        this.setTop(etiqueta);
        setAlignment(etiqueta, Pos.TOP_CENTER);
    }

}