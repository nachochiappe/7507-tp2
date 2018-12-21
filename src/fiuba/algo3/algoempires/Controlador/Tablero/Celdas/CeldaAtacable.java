package fiuba.algo3.algoempires.Controlador.Tablero.Celdas;

import java.io.File;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.Alerts.ContenedorAlerta;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class CeldaAtacable  implements EventHandler<MouseEvent> {

	ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	Posicion posicion;
	Ofensiva ofensiva;
	Posicionable atacado;
	MediaPlayer sonidoDeGolpe;

	
	public CeldaAtacable(ContenedorPantallaDeJuego contenedor, Ofensiva ofensiva, Posicionable atacado, Posicion posicion) {
		this.contenedorPantallaDeJuego = contenedor;
		this.ofensiva = ofensiva;
		this.posicion = posicion;
		this.atacado = atacado;
		
		String musicFile = "src/fiuba/algo3/algoempires/Vista/Sonidos/Golpe.wav";
		Media sound = new Media(new File(musicFile).toURI().toString()); 
		this.sonidoDeGolpe = new MediaPlayer(sound); 
	}


	@Override
	public void handle(MouseEvent arg0) {
		try {
			ofensiva.atacar(atacado);
			contenedorPantallaDeJuego.actualizarJugadorHUD();
			sonidoDeGolpe.play();
			contenedorPantallaDeJuego.getVistaTablero().iniciarTablero(contenedorPantallaDeJuego, contenedorPantallaDeJuego.algoEmpires.getJugadorActual());
		} catch (ObjetivoFueraDeRangoException | ArmaDeAsedioNoAtacaUnidadesException | ArmaDeAsedioNoMontadaException | AtaqueAliadoException e) {
			new ContenedorAlerta().display(contenedorPantallaDeJuego.rootStage, e.getMessage());
		} catch (FueraDelMapaException e) {
			e.printStackTrace();
		}
	}

}
