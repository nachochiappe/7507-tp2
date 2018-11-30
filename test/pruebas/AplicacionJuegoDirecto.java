package pruebas;

import fiuba.algo3.algoempires.Controlador.AplicacionOnKeyPressEventHandler;
import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Vista.ContenedorPantallaDeJuego;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AplicacionJuegoDirecto  extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		AlgoEmpires algoEmpires = new AlgoEmpires();
		algoEmpires.agregarJugador("UNO");
		algoEmpires.agregarJugador("DOS");
		algoEmpires.empezarJuego();
		stage.setTitle("Algo Empires Pruebas"); 

     
        ContenedorPantallaDeJuego contenedorPantallaDeJuego = new ContenedorPantallaDeJuego(stage, algoEmpires);
        Scene escenaJuego = new Scene(contenedorPantallaDeJuego, 1024, 768);
        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPantallaDeJuego.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(aplicacionOnKeyPressEventHandler);

        stage.setScene(escenaJuego);
        stage.show();	
	}

	
}
