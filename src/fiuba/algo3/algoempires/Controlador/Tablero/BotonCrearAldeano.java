package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonCrearAldeano implements EventHandler<ActionEvent>  {

	private PlazaCentral plazaCentral;
	private boolean puedoCrearAldeano = false;
	
	public BotonCrearAldeano(PlazaCentral plazaCentral) {
		this.plazaCentral = plazaCentral;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println("Boton presionado");
		puedoCrearAldeano = true;
		
	}
	
	public void handle(MouseEvent event) {
		
		
	}
	

}
