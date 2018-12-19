package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio;

import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.layout.VBox;

public class ArmaDeAsedioMontada implements ArmaDeAsedioEstado {

    ArmaDeAsedio armaDeAsedio;

    public ArmaDeAsedioMontada(ArmaDeAsedio armaDeAsedio) {
        this.armaDeAsedio = armaDeAsedio;
    }

    @Override
    public void mover(Desplazamiento posicion) throws ArmaDeAsedioMontadaException {
        throw new ArmaDeAsedioMontadaException();
    }


    public void atacar(Posicionable edificio) throws ArmaDeAsedioNoMontadaException, ArmaDeAsedioNoAtacaUnidadesException {
    	edificio.atacadoPor(this.armaDeAsedio);
    }

    @Override
    public void toggleMontar() {
        this.armaDeAsedio.setEstado(this.armaDeAsedio.getDesmontada());
    }

    @Override
    public String getNombre() {
        return "Arma de Asedio (montada)";
    }

    @Override
    public VBox getBotoneraAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
        return botoneraAcciones.generarBotonera(contenedor, this);
    }
}
