package fiuba.algo3.algoempires.Deprecated.AldeanoConstruccionReparacionSumatoriaOro;

import fiuba.algo3.algoempires.Model.Jugador.Jugador;

public class SumaOro implements SumatoriaOro {

	@Override
	public void sumarOro(Jugador jugador, int oro) {
		jugador.modificarOro(20);
	}

}
