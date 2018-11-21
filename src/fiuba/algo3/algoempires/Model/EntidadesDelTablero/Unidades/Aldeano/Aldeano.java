package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaConstruyendoException;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoYaEstaReparandoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;

public class Aldeano extends Unidad {
	
	private Construccion construyendo = new Construyendo();
	private Construccion noConstruyendo = new NoConstruyendo();
	private Construccion construccion;
	private Reparacion reparando = new Reparando();
	private Reparacion noReparando = new NoReparando();
	private Reparacion reparacion;
	private SumatoriaOro sumaOro = new SumaOro();
	private SumatoriaOro noSumaOro = new NoSumaOro();
	private SumatoriaOro sumatoria_oro;
	

    private final int MAX_HP = 50;
    private final int COSTO = 25;

    public Aldeano(Jugador jugador, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.jugador = jugador;
        this.posicion = posicion;
        this.construccion = noConstruyendo;
        this.reparacion = noReparando;
        this.sumatoria_oro = sumaOro;
    }

	public void construir(Construible construible, Posicion posicion) throws AldeanoYaEstaConstruyendoException, FueraDelMapaException {
		this.construccion.construir(construible, posicion);
        this.deshabilitarConstruccion();
        return;
	}

	public void comenzarTurno() {
    	this.habilitarMovimiento();
    	this.sumarOro();
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

	public void reparar(Edificio edificio) throws AldeanoYaEstaReparandoException {
		this.reparacion.reparar(edificio, this);
		this.deshabilitarReparacion();
		return;
	}
	
	public void habilitarReparacion() {
		this.reparacion = noReparando;
		this.sumatoria_oro = sumaOro;
	}

	public void deshabilitarReparacion() {
		this.reparacion = reparando;
		this.sumatoria_oro = noSumaOro;
	}

	@Override
	public boolean estaVacio() {
		return false;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) {
		this.recibeDanioDe(ofensivo);
	}

}
