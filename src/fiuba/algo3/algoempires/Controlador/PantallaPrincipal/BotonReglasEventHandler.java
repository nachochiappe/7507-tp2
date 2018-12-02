package fiuba.algo3.algoempires.Controlador.PantallaPrincipal;

import fiuba.algo3.algoempires.Vista.MenuPrincipal.ContenedorReglas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonReglasEventHandler implements EventHandler<ActionEvent> {

    Stage stage;

    public BotonReglasEventHandler(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        new ContenedorReglas().display(stage);
    }
}
