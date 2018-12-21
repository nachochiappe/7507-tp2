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

public class VistaPlazaCentral extends VistaEdificio {

	public VistaPlazaCentral(ContenedorPantallaDeJuego contenedor, Edificio plazaCentral, Jugador jugadorActual) {
		super(contenedor, plazaCentral, jugadorActual);
		if (plazaCentral.getJugador().equals(contenedor.algoEmpires.getJugadorActual())) {
			this.imagenEdificio = new Image(plazaCentral.getSpritePath());
		} else {
			String imagePath = plazaCentral.getSpritePath().split(".png")[0] + "(Rojo)";
			imagePath = imagePath.concat(".png");
			this.imagenEdificio = new Image(imagePath);
		}
    }
	
	@Override
	protected void mostrarMenuEdificio() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void esperarConstruccion(ContenedorPantallaDeJuego contenedor, Aldeano aldeano, Edificio edificio, Posicion posicion, List<VistaPosicionable> vistaPosicionables) {

	}

	@Override
	public void esperarAtaque(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Ofensiva ofensiva,
			Posicion posicion) {
		// TODO Auto-generated method stub
		
	}
}
