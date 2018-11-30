package fiuba.algo3.algoempires.Controlador.PantallaLogin;

import fiuba.algo3.algoempires.Controlador.AplicacionOnKeyPressEventHandler;
import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Excepciones.CantidadJugadoresIncorrectaException;
import fiuba.algo3.algoempires.Vista.ContenedorInvalidInput;
import fiuba.algo3.algoempires.Vista.ContenedorPantallaDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonComenzarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Stage rootStage;
    VBox jugadores;

    public BotonComenzarEventHandler(Stage stage, Stage rootStage, VBox usuarios) {
        this.stage = stage;
        this.rootStage = rootStage;
        this.jugadores = usuarios;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        TextField jugador1 = (TextField)jugadores.getChildren().get(1);
        TextField jugador2 = (TextField)jugadores.getChildren().get(3);

        if((jugador1.getText().trim().equals("")) || jugador2.getText().trim().equals("")) {
            ContenedorInvalidInput contenedorInvalidInput = new ContenedorInvalidInput();
            contenedorInvalidInput.display(stage);
        } else {

            AlgoEmpires algoEmpires = new AlgoEmpires();

            algoEmpires.agregarJugador(jugador1.getText());
            algoEmpires.agregarJugador(jugador2.getText());

            try {
                algoEmpires.empezarJuego();

                ContenedorPantallaDeJuego contenedorPantallaDeJuego = new ContenedorPantallaDeJuego(stage, algoEmpires);
                Scene escenaJuego = new Scene(contenedorPantallaDeJuego, 1024, 768);
                AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPantallaDeJuego.getBarraDeMenu());
                escenaJuego.setOnKeyPressed(aplicacionOnKeyPressEventHandler);

                stage.close();
                rootStage.setScene(escenaJuego);
                rootStage.setFullScreenExitHint("");
                rootStage.setFullScreen(true);
            } catch (CantidadJugadoresIncorrectaException e) {
                e.printStackTrace();
            }
        }
    }
}
