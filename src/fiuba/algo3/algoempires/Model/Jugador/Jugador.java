package fiuba.algo3.algoempires.Model.Jugador;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Tablero;
import javafx.geometry.Pos;

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
    private Posicion posicion;

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
        edificios.add(new Castillo());
        edificios.add(new PlazaCentral());
    }


    //Constructor llamado únicamente al principio del juego
    public Jugador(String nombre, Posicion posicion) {

        this.nombre = nombre;
        this.posicion = posicion;
        this.estado = new Deshabilitado();
        this.oro = ORO_INICIAL;
        this.tope_poblacion = TOPE_POBLACION;
        this.edificios = new ArrayList<>();
        this.unidades = new ArrayList<>();
        if (posicion.getPosicionX() == 0) {
        	Castillo castillo = new Castillo(new Posicion(posicion.getPosicionX(), posicion.getPosicionY()), this);
        	castillo.setEstadoEdilicioIdle();
        	edificios.add(castillo);
        	PlazaCentral plazaCentral = new PlazaCentral(new Posicion(posicion.getPosicionX() + 5, posicion.getPosicionY()), this);
        	plazaCentral.setEstadoEdilicioIdle();
        	edificios.add(plazaCentral);
        	for (int i = 0; i < ALDEANOS_INICIALES; i++) {
                Aldeano aldeano = new Aldeano(this, new Posicion(posicion.getPosicionX() + 5 + i, posicion.getPosicionY() + 2));
                unidades.add(aldeano);
                try {
                    Tablero.getInstance().poner(null, aldeano.getPosicion(), aldeano);
                } catch (PosicionOcupadaException | DestinoFueraDelMapaException e) {
                    //Nunca debería llegar acá
                    System.out.println("What a Terrible Error");
                }
            }
        }
        else {
        	Castillo castillo = new Castillo(new Posicion(posicion.getPosicionX() - 3, posicion.getPosicionY() - 3), this);
        	castillo.setEstadoEdilicioIdle();
        	edificios.add(castillo);
        	PlazaCentral plazaCentral = new PlazaCentral(new Posicion(posicion.getPosicionX() - 6, posicion.getPosicionY() - 1), this);
        	plazaCentral.setEstadoEdilicioIdle();
        	edificios.add(plazaCentral);
        	for (int i = 0; i < ALDEANOS_INICIALES; i++) {
                Aldeano aldeano = new Aldeano(this, new Posicion(posicion.getPosicionX() - 9 + i, posicion.getPosicionY() - 2));
                unidades.add(aldeano);
                try {
                    Tablero.getInstance().poner(null, aldeano.getPosicion(), aldeano);
                } catch (PosicionOcupadaException | DestinoFueraDelMapaException e) {
                    //Nunca debería llegar acá
                    System.out.println("What a Terrible Error");
                }
            }
        }
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

    public void moverUnidad(Unidad unidad, Desplazamiento desplazamiento) throws DestinoFueraDelMapaException, UnidadYaSeMovioException, PosicionOcupadaException {
        unidades.get(unidades.indexOf(unidad)).mover(desplazamiento);
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

    public void modificarOro(int oro) {
        this.oro += oro;
    }

    public void agregarOro(int oro) {
        this.oro += oro;
    }

    public void sacarOro(int oro) throws OroInsuficienteException {
        if(this.oro < oro) {
            throw new OroInsuficienteException();
        } else {
            this.oro = this.oro - oro;
        }
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
