package fiuba.algo3.algoempires.Controlador.Tablero.Celdas;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CeldaAtacable  implements EventHandler<MouseEvent> {

	ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	Posicion posicion;
	Ofensiva ofensiva;
	Posicionable atacado;
	
	public CeldaAtacable(ContenedorPantallaDeJuego contenedor, Ofensiva ofensiva, Posicionable atacado, Posicion posicion) {
		this.contenedorPantallaDeJuego = contenedor;
		this.ofensiva = ofensiva;
		this.posicion = posicion;
		this.atacado = atacado;
	}


	@Override
	public void handle(MouseEvent arg0) {
		try {
			ofensiva.atacar(atacado);
		} catch (ObjetivoFueraDeRangoException | ArmaDeAsedioNoAtacaUnidadesException
				| ArmaDeAsedioNoMontadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
