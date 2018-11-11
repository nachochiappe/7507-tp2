package fiuba.algo3.algoempires.Model.Entidades.Unidades.Ofensivas.ArmaDeAsedio;

public interface ArmaDeAsedioEstado {

    void mover(int posicion);
    void atacar(Object edificio);
    //Montar/Desmontar
    void toggleMontar();
}
