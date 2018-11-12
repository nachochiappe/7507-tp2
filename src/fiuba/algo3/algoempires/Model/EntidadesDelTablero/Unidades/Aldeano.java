package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaConstruyendoException;
import fiuba.algo3.algoempires.Model.Tablero;

public class Aldeano extends Unidad {
	
	private Construccion construyendo = new Construyendo();
	private Construccion noConstruyendo = new NoConstruyendo();
	Construccion construccion;

    private final int MAX_HP = 50;
    private final int COSTO = 25;
    Tablero tablero;

    public Aldeano(Tablero _tablero, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.tablero = _tablero;
        this.posicion = posicion;
        this.construccion = noConstruyendo;
    }

	public void construir(Construible construible, Posicion posicion) throws AldeanoYaEstaConstruyendoException {
		this.construccion.construir(construible, posicion);
        this.deshabilitarConstruccion();
        return;
	}

	public void habilitarConstruccion() {
		this.construccion = noConstruyendo;
	}

	public void deshabilitarConstruccion() {
		this.construccion = construyendo;
	}
}
