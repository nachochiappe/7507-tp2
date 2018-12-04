package fiuba.algo3.algoempires.Controlador;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaAldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class VistaAldeanoEventHandler implements EventHandler<ActionEvent>{

	Aldeano aldeano;
	VistaAldeano vistaAldeano;
	public VistaAldeanoEventHandler(Aldeano aldeano, VistaAldeano vistaAldeano) {
		this.aldeano = aldeano;
		this.vistaAldeano = vistaAldeano;
	}

	@Override
	public void handle(ActionEvent arg0) {
//		vistaAldeano.clean();
		
	}

}
