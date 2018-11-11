package fiuba.algo3.algoempires.Model.Entidades.Unidades.Ofensivas.ArmaDeAsedio;

public class ArmaDeAsedioMontada implements ArmaDeAsedioEstado {

    ArmaDeAsedio armaDeAsedio;

    public ArmaDeAsedioMontada(ArmaDeAsedio armaDeAsedio) {
        this.armaDeAsedio = armaDeAsedio;
    }

    @Override
    public void mover(int posicion) {
        //TODO: DEVOLVER ARMA "MONTADA NO PUEDE MOVERSE EXCEPTION"
    }

    @Override
    public void atacar(Object edificio) {

    }

    @Override
    public void toggleMontar() {
        this.armaDeAsedio.setEstado(this.armaDeAsedio.getDesmontada());
    }
}
