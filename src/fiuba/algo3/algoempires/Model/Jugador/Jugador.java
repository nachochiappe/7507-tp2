package fiuba.algo3.algoempires.Model.Jugador;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.Tablero;

import java.util.ArrayList;

public class Jugador {

    private final int ORO_INICIAL = 100;
    private final int ALDEANOS_INICIALES = 3;

    private String nombre;
    private int oro;
    private ArrayList<Unidad> unidades;
    private ArrayList<Object> edificios;
    Tablero tablero;

    public Jugador(String nombre, Tablero tablero) {
        this.tablero = tablero;
        this.nombre = nombre;
        this.oro =  ORO_INICIAL;
        this.unidades = new ArrayList<>();
        for (int i = 0; i < ALDEANOS_INICIALES; i++) {
            unidades.add(new Aldeano(this.tablero, this, new Posicion(i, i)));
        }
        //TODO: Asignarle el edificio
    }


    public void moverUnidad(Object unidad, Object posicion) {
        System.out.println("Mueve la unidad");
    }

    public void empezarTurno() {
        for(Unidad unidad: unidades) {
            unidad.habilitarMovimiento();
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
}
