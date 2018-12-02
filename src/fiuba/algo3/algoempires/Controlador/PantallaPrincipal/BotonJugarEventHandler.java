package fiuba.algo3.algoempires.Controlador.PantallaPrincipal;

import fiuba.algo3.algoempires.Vista.Login.ContenedorRegistroDeJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;

    public BotonJugarEventHandler(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        new ContenedorRegistroDeJugadores().display(stage);
    }
}
