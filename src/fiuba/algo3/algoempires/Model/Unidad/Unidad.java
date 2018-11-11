package fiuba.algo3.algoempires.Model.Unidad;

public abstract class Unidad {

    //Todas las unidades tienen hp y costo
    protected int hp;
    protected int costo;
    //TODO: Determinar si cada unidad va a tener una referencia a su Jugador o solamente el nombre
    private String jugador;

    public void mover(int posicion) {
        return;
    }

    public int getCosto() {
        return costo;
    }

    public int getHp() {
        return hp;
    }
}
