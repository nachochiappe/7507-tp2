package fiuba.algo3.algoempires.Model.Jugador;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.PlazaCentral;
import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;

import java.util.ArrayList;

public class Jugador {

    private final int ORO_INICIAL = 100;
    private final int ALDEANOS_INICIALES = 3;

    private String nombre;
    private int oro;
    private ArrayList<Unidad> unidades;
    private ArrayList<Edificio> edificios;


    public Jugador(String nombre) {

        this.nombre = nombre;
        this.oro =  ORO_INICIAL;
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
        for(Unidad unidad: unidades) {
            unidad.comenzarTurno();
        }
    }

    public void terminarTurno() {
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

    public void modificarOro(int oro) {
        this.oro += oro;
    }

    public void agregarUnidad(Unidad unidad){
        this.unidades.add(unidad);
    }

    public int obtenerPoblacion() { return this.unidades.size(); }

    //TODO: BORRAR ESTO DESPUES DE LA ENTREGA 2
    public PlazaCentral getPlazaCentral() {
        return (PlazaCentral)this.edificios.get(0);
    }
}
