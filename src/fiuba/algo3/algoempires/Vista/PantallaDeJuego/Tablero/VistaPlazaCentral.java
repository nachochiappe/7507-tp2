package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class VistaPlazaCentral extends VistaEdificio {

	public VistaPlazaCentral(ContenedorPantallaDeJuego contenedor, Edificio plazaCentral, Jugador jugadorActual) {
		super(contenedor, plazaCentral, jugadorActual);
    	this.imagenEdificio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/PlazaCentral/PlazaCentralConstruida.png");
    	inicializar();
    }
	
	@Override
	protected void mostrarMenuEdificio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Posicion getPosicion() {
		return null;
	}

	@Override
	public void setearClickListener(EventHandler<MouseEvent> eventEventHandler) {

	}
}
