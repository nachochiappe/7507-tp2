package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.layout.VBox;

public class AldeanoIdle implements EstadoAldeano{

    private Aldeano aldeano;

    AldeanoIdle(Aldeano aldeano) {
        this.aldeano = aldeano;
    }

    @Override
    public void comenzarTurno() {
        this.aldeano.sumarOro();
    }

    @Override
    public String getNombre() {
        return "Aldeano";
    }

    @Override
    public void empezarConstruccion(Edificio edificio, Posicion posicion) throws FueraDelMapaException, SoloSePermiteUnAldeanoException, OroInsuficienteException {
        edificio.construiteEn(this.aldeano, posicion);
    }

    @Override
    public void terminarAccion() {

    }

	@Override
	public void empezarReparacion(Edificio edificio) throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException, AldeanoOcupadoException {
		edificio.edificar(this.aldeano);
	}

    @Override
    public VBox getBotonearaAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
        return botoneraAcciones.generarBotonera(contenedor, this);
    }

    public Aldeano getAldeano() {
        return this.aldeano;
    }

}
