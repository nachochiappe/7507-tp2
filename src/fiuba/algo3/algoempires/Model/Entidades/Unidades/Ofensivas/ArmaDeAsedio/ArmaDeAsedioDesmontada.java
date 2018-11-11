package fiuba.algo3.algoempires.Model.Entidades.Unidades.Ofensivas.ArmaDeAsedio;

public class ArmaDeAsedioDesmontada implements ArmaDeAsedioEstado{

    ArmaDeAsedio armaDeAsedio;

    public ArmaDeAsedioDesmontada(ArmaDeAsedio armaDeAsedio) {
        this.armaDeAsedio = armaDeAsedio;
    }

    @Override
    public void mover(int posicion) {

    }

    @Override
    public void atacar(Object edificio) {
    //TODO: DEVOLVER ARMA "MONTADA NO PUEDE ATACAR EXCEPTION"
    }

    @Override
    public void toggleMontar() {
        this.armaDeAsedio.setEstado(this.armaDeAsedio.getMontada());
    }
}
