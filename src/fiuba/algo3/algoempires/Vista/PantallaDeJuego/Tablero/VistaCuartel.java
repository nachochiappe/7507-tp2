package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class VistaCuartel extends VistaEdificio {


	public VistaCuartel(ContenedorPantallaDeJuego contenedor, Edificio cuartel, Jugador jugadorActual) {
		super(contenedor, cuartel, jugadorActual);
		this.imagenEdificio = cuartel.getSprite();
    	inicializar();
    }
	
	@Override
	protected void mostrarMenuEdificio() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void esperarConstruccion(ContenedorPantallaDeJuego contenedor, Aldeano aldeano, Edificio edificio, Posicion posicion, List<VistaPosicionable> vistaPosicionables) {

	}

}
