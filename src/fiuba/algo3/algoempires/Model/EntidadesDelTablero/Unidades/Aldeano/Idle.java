package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class Idle implements EstadoAldeano{

    private Aldeano aldeano;

    public Idle(Aldeano aldeano) {
        this.aldeano = aldeano;
    }

    @Override
    public void comenzarTurno() {
        this.aldeano.sumarOro();
    }

    @Override
    public void construir(Edificio edificio) {
        this.aldeano.empezarAConstruir(edificio);
    }

    @Override
    public void reparar(Edificio edificio) {
        this.aldeano.empezarAReparar(edificio);
    }

    @Override
    public void empezarConstruccion(Edificio edificio, Posicion posicion) throws FueraDelMapaException {
        edificio.construiteEn(this.aldeano, posicion);
    }

    @Override
    public void terminarAccion() {

    }

}
