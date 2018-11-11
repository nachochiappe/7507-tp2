package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio;

import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;

public interface ArmaDeAsedioEstado {

    void mover(Desplazamiento posicion) throws ArmaDeAsedioMontadaException;
    void atacar(Object edificio) throws ArmaDeAsedioNoMontadaException;
    //Montar/Desmontar
    void toggleMontar();
}
