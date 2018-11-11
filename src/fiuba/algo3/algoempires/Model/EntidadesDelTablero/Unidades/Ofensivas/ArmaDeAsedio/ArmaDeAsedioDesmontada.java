package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio;

import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;

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
    public void atacar(Object edificio) throws ArmaDeAsedioNoMontadaException {
        throw new ArmaDeAsedioNoMontadaException();
    }

    @Override
    public void toggleMontar() {
        this.armaDeAsedio.setEstado(this.armaDeAsedio.getMontada());
    }
}
