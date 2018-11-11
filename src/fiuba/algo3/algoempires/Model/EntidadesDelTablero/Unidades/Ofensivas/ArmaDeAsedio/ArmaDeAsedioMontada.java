package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio;

import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
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

    @Override
    public void atacar(Object edificio) throws ArmaDeAsedioNoMontadaException {

    }

    @Override
    public void toggleMontar() {
        this.armaDeAsedio.setEstado(this.armaDeAsedio.getDesmontada());
    }
}
