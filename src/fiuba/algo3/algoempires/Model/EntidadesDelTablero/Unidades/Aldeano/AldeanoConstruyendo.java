package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoOcupadoException;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioNoNecesitaRepararse;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioYaConstruidoException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.layout.VBox;

public class AldeanoConstruyendo implements EstadoAldeano {

	private Aldeano aldeano;
	private Edificio edificio;

	AldeanoConstruyendo(Aldeano aldeano, Edificio edificio) {
		this.aldeano = aldeano;
		this.edificio = edificio;
	}

	@Override
	public void comenzarTurno() throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException {
		this.edificio.edificar(this.aldeano);
	}

	@Override
	public String getNombre() {
		return "Aldeano (Ocupado)";
	}

	@Override
	public void empezarConstruccion(Edificio edificio, Posicion posicion) throws AldeanoOcupadoException {
		throw new AldeanoOcupadoException();
	}

	@Override
	public void terminarAccion() {
		this.edificio.desligarAldeano();
	}

	@Override
	public VBox getBotonearaAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
		return botoneraAcciones.generarBotonera(contenedor, this);
	}

	@Override
	public void empezarReparacion(Edificio edificio) throws AldeanoOcupadoException {
		throw new AldeanoOcupadoException();
		
	}

	public Aldeano getAldeano() {
		return this.aldeano;
	}
}
