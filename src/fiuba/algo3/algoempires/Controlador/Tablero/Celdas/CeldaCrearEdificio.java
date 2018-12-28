package fiuba.algo3.algoempires.Controlador.Tablero.Celdas;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.Alerts.ContenedorAlerta;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CeldaCrearEdificio implements EventHandler<MouseEvent>  {

    Aldeano aldeano;
    ContenedorPantallaDeJuego contenedorPantallaDeJuego;
    Posicion posicion;
    Edificio edificio;

    public CeldaCrearEdificio(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Aldeano aldeano, Edificio edificio, Posicion posicion) {
        this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
        this.aldeano = aldeano;
        this.edificio = edificio;
        this.posicion = posicion;
    }

    @Override
    public void handle(MouseEvent event) {
        try {
            this.aldeano.construir(edificio, posicion);
            this.contenedorPantallaDeJuego.actualizarJugadorHUD();
            this.contenedorPantallaDeJuego.leftBorderPane.setCenter(new SeleccionableHUD());
        } catch (AldeanoOcupadoException | FueraDelMapaException | SoloSePermiteUnAldeanoException | OroInsuficienteException  | PosicionOcupadaException e)  {
            new ContenedorAlerta().display(contenedorPantallaDeJuego.rootStage, "No se puede construir aquí");
        }

        try {
			contenedorPantallaDeJuego.vistaTablero.iniciarTablero(contenedorPantallaDeJuego, contenedorPantallaDeJuego.algoEmpires.getJugadorActual());
		} catch (FueraDelMapaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }



}
