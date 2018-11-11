package fiuba.algo3.algoempires.Model.Unidad.Unidades.Ofensivas.ArmaDeAsedio;

public interface ArmaDeAsedioEstado {

    void mover(int posicion);
    void atacar(Object edificio);
    //Montar/Desmontar
    void toggleMontar();
}
