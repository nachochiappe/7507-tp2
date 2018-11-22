package fiuba.algo3.algoempires.Model.Jugador;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.ExcedeTopePoblacionalException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;

import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {

    private final int ORO_INICIAL = 100;
    private final int ALDEANOS_INICIALES = 3;
    private final int TOPE_POBLACION = 50;

    private String nombre;
    private EstadoJugador estado;
    private int oro;
    private int tope_poblacion;
    private ArrayList<Unidad> unidades;
    private ArrayList<Edificio> edificios;


    public Jugador(String nombre) {

        this.nombre = nombre;
        this.estado = new Deshabilitado();
        this.oro = ORO_INICIAL;
        this.tope_poblacion = TOPE_POBLACION;
        this.unidades = new ArrayList<>();
        for (int i = 0; i < ALDEANOS_INICIALES; i++) {
            unidades.add(new Aldeano(this, new Posicion(i, i)));
        }
        edificios = new ArrayList<>();
        edificios.add(new PlazaCentral());
    }


    public void moverUnidad(Unidad unidad, Desplazamiento desplazamiento) throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
        unidades.get(unidades.indexOf(unidad)).mover(desplazamiento);
    }


    public void empezarTurno() {
    	this.estado = new Habilitado();
        for(Unidad unidad: unidades) {
            unidad.comenzarTurno();
        }
    }

    public void terminarTurno() {
    	this.estado = new Deshabilitado();
        System.out.println("Termina el turno");
    }


    public String getNombre() {
        return nombre;
    }

    public ArrayList<Unidad> getUnidades() {
        return unidades;
    }

    public int getOro() {
        return oro;
    }
    
    public void sumarOroDelTurno() {
    	for (Iterator<Unidad> it = unidades.iterator(); it.hasNext();) {
    		Unidad unidad = it.next();
    		if (unidad instanceof Aldeano) {
    			((Aldeano) unidad).sumarOro();
    		}
    	}
    }

    public void modificarOro(int oro) {
        this.oro += oro;
    }

    public void agregarOro(int oro) {
        this.oro += oro;
    }

    public void agregarUnidad(Unidad unidad) throws ExcedeTopePoblacionalException {
    	if (this.unidades.size() < this.tope_poblacion) {
    		this.unidades.add(unidad);
    	}
    	else {
    		throw new ExcedeTopePoblacionalException();
    	}
    }

    public int obtenerPoblacion() { return this.unidades.size(); }

    //TODO: BORRAR ESTO DESPUES DE LA ENTREGA 2
    public PlazaCentral getPlazaCentral() {
        return (PlazaCentral)this.edificios.get(0);
    }
}
