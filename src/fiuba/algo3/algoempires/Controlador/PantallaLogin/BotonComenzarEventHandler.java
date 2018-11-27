package fiuba.algo3.algoempires.Controlador.PantallaLogin;

import fiuba.algo3.algoempires.Controlador.AplicacionOnKeyPressEventHandler;
import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Vista.ContenedorPantallaDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonComenzarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Stage rootStage;

    public BotonComenzarEventHandler(Stage stage, Stage rootStage) {
        this.stage = stage;
        this.rootStage = rootStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorPantallaDeJuego contenedorPantallaDeJuego = new ContenedorPantallaDeJuego(stage);
        Scene escenaJuego = new Scene(contenedorPantallaDeJuego, 1024, 768);
        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPantallaDeJuego.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);



        stage.close();
        rootStage.setScene(escenaJuego);
        rootStage.setFullScreenExitHint("");
        rootStage.setFullScreen(true);
    }
}
