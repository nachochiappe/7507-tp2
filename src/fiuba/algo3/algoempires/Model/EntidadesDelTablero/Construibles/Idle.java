package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

public class Idle implements EstadoEdilicio {

    private Edificio edificio;

    public Idle(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public void comenzarTurno() {
        //No hace nada
    }

    @Override
    public void crearUnidad() {

    }
}
