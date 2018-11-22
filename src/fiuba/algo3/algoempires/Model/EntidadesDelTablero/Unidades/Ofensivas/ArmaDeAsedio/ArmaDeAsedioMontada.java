package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio;

import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;

public class ArmaDeAsedioMontada implements ArmaDeAsedioEstado {

    ArmaDeAsedio armaDeAsedio;

    public ArmaDeAsedioMontada(ArmaDeAsedio armaDeAsedio) {
        this.armaDeAsedio = armaDeAsedio;
    }

    @Override
    public void mover(Desplazamiento posicion) throws ArmaDeAsedioMontadaException {
        throw new ArmaDeAsedioMontadaException();
    }


    public void atacar(Posicionable edificio) throws ArmaDeAsedioNoMontadaException {
    	edificio.atacadoPor(this.armaDeAsedio);
    }

    @Override
    public void toggleMontar() {
        this.armaDeAsedio.setEstado(this.armaDeAsedio.getDesmontada());
    }
}
