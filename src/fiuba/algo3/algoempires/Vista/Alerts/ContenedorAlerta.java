package fiuba.algo3.algoempires.Vista.Alerts;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static javafx.scene.text.Font.font;

public class ContenedorAlerta {

    public void display(Stage rootStage, String message) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(rootStage);
        stage.setTitle("Error");
        BorderPane borderPane = new BorderPane();
        Text text = new Text();
        text.setText(message);
        text.setFont(font("Helvetica", FontPosture.ITALIC, 20));

        borderPane.setCenter(text);
        Scene scene = new Scene(borderPane, 500, 200);

        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.showAndWait();
    }

}
