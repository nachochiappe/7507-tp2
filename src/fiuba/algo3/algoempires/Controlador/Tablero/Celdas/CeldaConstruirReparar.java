package fiuba.algo3.algoempires.Controlador.Tablero.Celdas;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.Alerts.ContenedorAlerta;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class CeldaConstruirReparar implements EventHandler<MouseEvent>  {

	ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	Edificio edificio;
	Aldeano aldeano;

    public CeldaConstruirReparar(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Edificio edificio, Aldeano aldeano) {
        this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
        this.edificio = edificio;
        this.aldeano = aldeano;
    }

	@Override
	public void handle(MouseEvent arg0) {
		try {
			this.aldeano.reparar(edificio);
		} catch (AldeanoOcupadoException | SoloSePermiteUnAldeanoException | EdificioNoNecesitaRepararse e) {
			new ContenedorAlerta().display(this.contenedorPantallaDeJuego.rootStage, e.getMessage());
		}
	}

}
