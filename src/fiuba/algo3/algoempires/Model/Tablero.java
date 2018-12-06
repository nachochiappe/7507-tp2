package fiuba.algo3.algoempires.Model;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.LugarVacio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.PosicionOcupadaException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tablero {
    private static Tablero ourInstance = new Tablero();

    public static Tablero getInstance() {
        return ourInstance;
    }

    private Tablero() {

    }
    private Posicionable[][] matriz =  new Posicionable[ANCHO][ALTO];;
    private static final int ANCHO = 20;
    private static final int ALTO = 20;

    public void inicializarTablero() {
        for (int i=0; i<ANCHO; i++) {
            for(int j=0; j<ALTO; j++) {
                matriz[i][j] = new LugarVacio();
            }
        }
    }

    public boolean estasVacio() {
        for (int i=0; i<ANCHO; i++) {
            for(int j=0; j<ALTO; j++) {
                if(!(matriz[i][j].estaVacio())) return false;
            }
        }
        return true;
    }


    public void poner(Posicionable posicionable, Posicion posicionDeInicio, Posicion posicionDeFin) throws FueraDelMapaException {
        if(!posicionDeFin.dentroDe(ANCHO,ALTO)) throw new FueraDelMapaException("Fuera del mapa!");
        System.out.println(posicionDeInicio.getPosicionX());
        System.out.println(posicionDeInicio.getPosicionY());
        System.out.println(posicionDeFin.getPosicionX());
        System.out.println(posicionDeFin.getPosicionY());
        for(int i = posicionDeInicio.getPosicionX(); i<=posicionDeFin.getPosicionX(); i++) {
            for(int j = posicionDeInicio.getPosicionY(); j<=posicionDeFin.getPosicionY(); j++) {
                matriz[i][j] = posicionable;
            }
        }
    }

    public void poner(Posicion posicionAnterior, Posicion posicionNueva, Posicionable posicionable) throws PosicionOcupadaException, DestinoFueraDelMapaException {
        try {
            Posicionable actual = matriz[posicionNueva.getPosicionX()][posicionNueva.getPosicionY()];
            if (actual != null) {
            	if(!actual.estaVacio()) throw new PosicionOcupadaException();
            }
            matriz[posicionNueva.getPosicionX()][posicionNueva.getPosicionY()] = posicionable;
            if (posicionAnterior != null) {
            	matriz[posicionAnterior.getPosicionX()][posicionAnterior.getPosicionY()] = new LugarVacio();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DestinoFueraDelMapaException();
        }
    }


    //Método llamado únicamente al principio del juego
    public void poner(Posicionable posicionable, LinkedList<Posicion> posiciones) {
        try {
            for(Posicion posicion: posiciones) {
                matriz[posicion.getPosicionX()][posicion.getPosicionY()] = posicionable;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //Nunca debería llegar acá
            System.out.println("What a Terrible Error");
        }
    }

    public Posicionable obtenerPosicionable(int posicionX, int posicionY) {
        return matriz[posicionX][posicionY];
    }
    
    public List<Posicionable> obtenerTodosLosPosicionables() {
    	List<Posicionable> posicionables = new ArrayList<>();
    	for (int i=0; i<ANCHO; i++) {
            for(int j=0; j<ALTO; j++) {
                if(!(matriz[i][j].estaVacio()) && !posicionables.contains(matriz[i][j])) {
                	posicionables.add(matriz[i][j]);
            	}
            }
        }
    	return posicionables;
    }

    public int getAncho() {
        return ANCHO;
    }

    public int getAlto() {
        return ALTO;
    }

    public static int ancho() {
        return ANCHO;
    }

    public static int alto() {
        return ANCHO;
    }
}
