package pruebas;

import fiuba.algo3.algoempires.Controlador.AplicacionOnKeyPressEventHandler;
import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AplicacionJuegoDirecto  extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		AlgoEmpires algoEmpires = new AlgoEmpires();
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero();

        algoEmpires.agregarJugador("Jugador1", new Posicion(0,0));
        algoEmpires.agregarJugador("Jugador2", new Posicion(19,19));

        algoEmpires.empezarJuego();
		stage.setTitle("Algo Empires Pruebas"); 

     
        ContenedorPantallaDeJuego contenedorPantallaDeJuego = new ContenedorPantallaDeJuego(stage, algoEmpires);
        Scene escenaJuego = new Scene(contenedorPantallaDeJuego, 1024, 768);
        escenaJuego.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> System.out.println( e));
        
        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPantallaDeJuego.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(aplicacionOnKeyPressEventHandler);

        stage.setScene(escenaJuego);
        stage.show();	
	}

	
}
