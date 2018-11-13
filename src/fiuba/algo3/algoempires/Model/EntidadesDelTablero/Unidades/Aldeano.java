package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaConstruyendoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Tablero;

public class Aldeano extends Unidad {
	
	private Construccion construyendo = new Construyendo();
	private Construccion noConstruyendo = new NoConstruyendo();
	private Construccion construccion;
	private SumatoriaOro sumaOro = new SumaOro();
	private SumatoriaOro noSumaOro = new NoSumaOro();
	private SumatoriaOro sumatoria_oro;
	

    private final int MAX_HP = 50;
    private final int COSTO = 25;
    Tablero tablero;

    public Aldeano(Tablero _tablero, Jugador jugador, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.jugador = jugador;
        this.tablero = _tablero;
        this.posicion = posicion;
        this.construccion = noConstruyendo;
        this.sumatoria_oro = sumaOro;
    }

	public void construir(Construible construible, Posicion posicion) throws AldeanoYaEstaConstruyendoException {
		this.construccion.construir(construible, posicion);
        this.deshabilitarConstruccion();
        return;
	}

	public void habilitarConstruccion() {
		this.construccion = noConstruyendo;
		this.sumatoria_oro = sumaOro;
	}

	public void deshabilitarConstruccion() {
		this.construccion = construyendo;
		this.sumatoria_oro = noSumaOro;
	}
	
	public void sumarOro() {
		this.sumatoria_oro.sumarOro(this.jugador, 20);
	}
}
