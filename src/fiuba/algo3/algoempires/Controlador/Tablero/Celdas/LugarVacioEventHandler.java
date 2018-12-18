package fiuba.algo3.algoempires.Controlador.Tablero.Celdas;

import fiuba.algo3.algoempires.Vista.MenuPrincipal.ContenedorPantallaPrincipal;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class LugarVacioEventHandler implements EventHandler<MouseEvent>{
	
	private ContenedorPantallaDeJuego contenedor;
	
	public LugarVacioEventHandler(ContenedorPantallaDeJuego contenedor) {
		this.contenedor = contenedor;
	}
	
	@Override
	public void handle(MouseEvent event) {
		this.contenedor.leftBorderPane.setCenter(new SeleccionableHUD());
		this.contenedor.vistaTablero.iniciarTablero(contenedor, contenedor.algoEmpires.getJugadorActual());
		
	}

}
