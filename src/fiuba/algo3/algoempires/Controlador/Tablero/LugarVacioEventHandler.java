package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class LugarVacioEventHandler implements EventHandler<MouseEvent>{
	
	private Button boton;
	private BorderPane border;
	
	public LugarVacioEventHandler(BorderPane borderPane) {
		border = borderPane;
	}
	LugarVacioEventHandler(Button boton){
		this.boton = boton;
	}
	
	@Override
	public void handle(MouseEvent event) {
		
		System.out.println("Click En lugar vaciiooo!");
		border.setCenter(new SeleccionableHUD());
//		Event.fireEvent(boton, new ActionEvent());
		
	}

}
