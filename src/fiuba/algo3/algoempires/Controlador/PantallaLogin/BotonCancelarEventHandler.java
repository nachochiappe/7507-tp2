package fiuba.algo3.algoempires.Controlador.PantallaLogin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonCancelarEventHandler implements EventHandler<ActionEvent> {

        Stage stage;
        Scene proximaEscena;

public BotonCancelarEventHandler(Stage stage) {
        this.stage = stage;
        }

@Override
public void handle(ActionEvent actionEvent) {
            this.stage.close();
        }
}