package fiuba.algo3.algoempires.Controlador.PantallaPrincipal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {


    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}
