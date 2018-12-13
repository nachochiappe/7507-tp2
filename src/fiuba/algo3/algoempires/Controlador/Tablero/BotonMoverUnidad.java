package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.PosicionOcupadaException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.Movimiento.Direccion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverUnidad implements EventHandler<ActionEvent> {

	private Desplazamiento desplazamiento;
	private Unidad unidad;
	private ContenedorPantallaDeJuego contenedor;
	
	public BotonMoverUnidad(ContenedorPantallaDeJuego _contenedor, Unidad _unidad, Desplazamiento _desplazamiento) {
		this.contenedor = _contenedor;
		this.unidad = _unidad;
		this.desplazamiento = _desplazamiento;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			Jugador jugador = this.contenedor.algoEmpires.getJugadorActual();
			this.unidad.mover(this.desplazamiento);
			this.contenedor.vistaTablero.iniciarTablero(this.contenedor, this.contenedor.algoEmpires.getJugadorActual());
			this.contenedor.leftBorderPane.setCenter(new SeleccionableHUD(this.contenedor, this.unidad, jugador));
		} catch (UnidadYaSeMovioException | DestinoFueraDelMapaException | PosicionOcupadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
