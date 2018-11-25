package fiuba.algo3.algoempires.Vista;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static javafx.scene.text.Font.font;

public class Reglas {

    public void display(Stage stage2) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(stage2);
        stage.setTitle("Reglas del juego");
        BorderPane borderPane = new BorderPane();
        Text text = new Text();
        text.setText("Reglas del juego");
        text.setFont(font("Helvetica", FontPosture.ITALIC, 20));

        borderPane.setCenter(text);
        Scene scene = new Scene(borderPane, 500, 600);

        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.showAndWait();
    }

}
