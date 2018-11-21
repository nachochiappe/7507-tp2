package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;

public class ArmaDeAsedio extends Unidad implements Ofensiva {

    private final int MAX_HP = 150;
    private final int COSTO = 200;

    private ArmaDeAsedioEstado estado;
    private ArmaDeAsedioMontada montada;
    private ArmaDeAsedioDesmontada desmontada;


    public ArmaDeAsedio(Jugador jugador, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        montada = new ArmaDeAsedioMontada(this);
        desmontada = new ArmaDeAsedioDesmontada(this);
        estado = desmontada;
        this.posicion = posicion;
    }

    public void mover(Desplazamiento desplazamiento) throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        try {
            this.estado.mover(desplazamiento);
            this.posicion = this.movimiento.mover(desplazamiento, this.posicion);
            this.deshabilitarMovimiento();
            return;
        } catch (ArmaDeAsedioMontadaException armaDeAsedioException) {
            armaDeAsedioException.printStackTrace();
        }
    }

    public void atacar(Object edificio) {
        try {
            this.estado.atacar(edificio);
        } catch (ArmaDeAsedioNoMontadaException e) {
            e.printStackTrace();
        }
    }

    public void toggleMontar() {
        this.estado.toggleMontar();
    }

    public void setEstado(ArmaDeAsedioEstado estado) {
        this.estado = estado;
    }

    public ArmaDeAsedioDesmontada getDesmontada() {
        return desmontada;
    }

    public ArmaDeAsedioMontada getMontada() {
        return montada;
    }

	@Override
	public boolean estaVacio() {
		return false;
	}

	@Override
	public void atacar(Unidad unidad) throws ObjetivoFueraDeRangoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacar(Edificio edificio) throws ObjetivoFueraDeRangoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int cuantoDanioAUnidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cuantoDanioAEdificio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) {
		this.recibeDanioDe(ofensivo);
	}

}
