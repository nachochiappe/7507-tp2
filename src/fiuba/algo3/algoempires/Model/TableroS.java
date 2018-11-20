package fiuba.algo3.algoempires.Model;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.LugarVacio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class TableroS {
    private static TableroS ourInstance = new TableroS();

    public static TableroS getInstance() {
        return ourInstance;
    }

    private TableroS() {

    }
    private Posicionable[][] matriz =  new Posicionable[ANCHO][ALTO];;
    static final int ANCHO = 20;
    static final int ALTO = 20;

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

    public void vaciarTablero() {
        for (int i=0; i<ANCHO; i++) {
            for(int j=0; j<ALTO; j++) {
                matriz[i][j] = new LugarVacio();
            }
        }
    }

    public void poner(Posicionable posicionable, Posicion posicionDeInicio, Posicion posicionDeFin) throws FueraDelMapaException {
        if(!posicionDeFin.dentroDe(ANCHO,ALTO)) throw new FueraDelMapaException("Fuera del mapa!");
        for(int i = posicionDeInicio.getPosicionX(); i<=posicionDeFin.getPosicionX(); i++) {
            for(int j = posicionDeInicio.getPosicionX(); j<=posicionDeFin.getPosicionY(); j++) {
                matriz[i][j] = posicionable;
            }
        }
    }

    public Posicionable obtenerPosicionable(int posicionX, int posicionY) {
        return matriz[posicionX][posicionY];
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
