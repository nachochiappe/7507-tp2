package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class VistaAldeano {

	private Image vacio;
    private Aldeano aldeano;
    private Image graficoAldeano;
    Canvas canvas;

    public VistaAldeano(Aldeano aldeano, Canvas canvas) {
        this.aldeano = aldeano;
        this.canvas = canvas;
        graficoAldeano = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/AldeanoConOro.png");
        vacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/lugarVacio.png");
    }

    public void dibujar() {
        this.clean();
        canvas.getGraphicsContext2D().drawImage(graficoAldeano, aldeano.getPosicion().getPosicionX() * 32, aldeano.getPosicion().getPosicionY() * 32);
    }

    public void clean() {
        canvas.getGraphicsContext2D().drawImage(vacio, aldeano.getPosicion().getPosicionX() * 32 , aldeano.getPosicion().getPosicionY() * 32);
    }

    public void update() {
        this.dibujar();
    }
}
