package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio;

import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.layout.VBox;

public class ArmaDeAsedioDesmontada implements ArmaDeAsedioEstado{

    ArmaDeAsedio armaDeAsedio;

    public ArmaDeAsedioDesmontada(ArmaDeAsedio armaDeAsedio) {
        this.armaDeAsedio = armaDeAsedio;
    }

    @Override
    public void mover(Desplazamiento posicion) throws ArmaDeAsedioMontadaException {
        return;
    }

    @Override
    public void atacar(Posicionable edificio) throws ArmaDeAsedioNoMontadaException{
		throw new ArmaDeAsedioNoMontadaException();

    }

    @Override
    public void toggleMontar() {
        this.armaDeAsedio.setEstado(this.armaDeAsedio.getMontada());
    }

    @Override
    public String getNombre() {
        return "Arma de Asedio (desmontada)";
    }

    @Override
    public VBox getBotoneraAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
        return botoneraAcciones.generarBotonera(contenedor, this);
    }
}
