package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import javafx.scene.layout.GridPane;

public class VistaTablero extends GridPane {

    List<Posicionable> posicionablesDibujados;
    VistaPosicionable[][] vistaPosicionables;
    Tablero tablero;

    public VistaTablero() {
        tablero = Tablero.getInstance();
        vistaPosicionables = new VistaPosicionable[tablero.getAncho()][tablero.getAlto()];
    }


    public void agregar(VistaUnidad vistaUnidad) {

        this.add(vistaUnidad, vistaUnidad.getPosY(), vistaUnidad.getPosX());
    }

    public void iniciarTablero(ContenedorPantallaDeJuego contenedor, Jugador jugadorActual) {
        posicionablesDibujados = new ArrayList<>();
        for (int i = 0; i < tablero.getAncho(); i++) {
            for (int j = 0; j < tablero.getAlto(); j++) {
                Posicionable posicionable = tablero.obtenerPosicionable(i, j);
                if (!(posicionablesDibujados.contains(posicionable))) {
                    VistaPosicionable vistaPosicionable = posicionable.getView(contenedor, jugadorActual);
                    vistaPosicionable.agregarATablero(this, posicionable, i, j);
                    posicionablesDibujados.add(posicionable);
                    vistaPosicionables[i][j] = vistaPosicionable;
                } else {
                    VistaPosicionable vistaPosicionable = posicionable.getView(contenedor, jugadorActual);
                   vistaPosicionables[i][j] = vistaPosicionable;
                }
            }
        }
    }

    public void iniciarConstruccion(Edificio e, Aldeano aldeano, ContenedorPantallaDeJuego contenedorPantallaDeJuego) {
        for (int i = 0; i < tablero.getAncho(); i++) {
            for (int j = 0; j < tablero.getAlto(); j++) {
                if (vistaPosicionables[i][j].getPosicion() != null) {
                    if (aldeano.getPosicion().estaEnRango(vistaPosicionables[i][j].getPosicion(), 1)) {
                        List<VistaPosicionable> list = new ArrayList<>();
                        for (int a = 0; a < e.getAncho(); a++) {
                            list.add(vistaPosicionables[i + a][j]);
                            for (int b = 0; b < e.getAlto(); b++ ) {
                                list.add(vistaPosicionables[i + a][j + b]);
                            }
                        }
                        vistaPosicionables[i][j].esperarConstruccion(contenedorPantallaDeJuego, aldeano, e, vistaPosicionables[i][j].getPosicion(), list);
                    }
                }
            }
        }
    }

    public void iniciarCreacionUnidad(Edificio e, Unidad unidad, ContenedorPantallaDeJuego contenedorPantallaDeJuego) {
        for (VistaPosicionable[] row : vistaPosicionables) {
            for (VistaPosicionable cell: row) {
                cell.esperarCreacionUnidad(contenedorPantallaDeJuego, e, unidad, cell.getPosicion());
            }
        }
    }


	public void iniciarAtaque(Ofensiva ofensiva, ContenedorPantallaDeJuego contenedorPantallaDeJuego) {
        for (VistaPosicionable[] row : vistaPosicionables) {
            for (VistaPosicionable cell: row) {
                cell.esperarAtaque(contenedorPantallaDeJuego, ofensiva, cell.getPosicion());
            }
        }
		
	}
}
