package fiuba.algo3.algoempires.Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.awt.Dimension;
import java.awt.Toolkit;

import fiuba.algo3.algoempires.Vista.Eventos.AplicacionOnKeyPressEventHandler;


public class Aplicacion extends Application {
	
	private static int width;
	private static int height;
	
    public static void main(String[] args) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.width;
		height = screenSize.height;
        launch(args);
    }
    
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Algo Empires");
        
        ContenedorPantallaDeJuego contenedorPantallaDeJuego = new ContenedorPantallaDeJuego(stage);
        Scene escenaJuego = new Scene(contenedorPantallaDeJuego, 1024, 768);
    
        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPantallaDeJuego.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler); 
      
        ContenedorPantallaPrincipal contenedorPantallaPrincipal = new ContenedorPantallaPrincipal(stage, escenaJuego);
        Scene escenaPrincipal = new Scene(contenedorPantallaPrincipal, 1024, 768);
        
        stage.setScene(escenaPrincipal);
        stage.setFullScreen(true);

        stage.show();
	}

}
