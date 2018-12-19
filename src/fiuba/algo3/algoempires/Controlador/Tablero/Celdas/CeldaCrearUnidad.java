package fiuba.algo3.algoempires.Controlador.Tablero.Celdas;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.Alerts.ContenedorAlerta;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;



public class CeldaCrearUnidad implements EventHandler<MouseEvent>  {
	
	ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	Posicion posicion;
	Edificio edificio;
	Unidad unidad;
	
    public CeldaCrearUnidad(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Edificio edificio, Unidad unidad, Posicion posicion) {
        this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
        this.edificio = edificio;
        this.posicion = posicion;
        this.unidad = unidad;
    }

	@Override
	public void handle(MouseEvent arg0) {
        try {
        	unidad.setPosicion(posicion);
			edificio.crearUnidad(unidad, posicion);
			contenedorPantallaDeJuego.actualizarJugadorHUD();
		} catch (OroInsuficienteException | ExcedeTopePoblacionalException | DestinoFueraDelMapaException | PosicionOcupadaException e) {
			new ContenedorAlerta().display(contenedorPantallaDeJuego.rootStage, e.getMessage());
		}
		contenedorPantallaDeJuego.getVistaTablero().iniciarTablero(contenedorPantallaDeJuego, contenedorPantallaDeJuego.algoEmpires.getJugadorActual());
		
	}

}
