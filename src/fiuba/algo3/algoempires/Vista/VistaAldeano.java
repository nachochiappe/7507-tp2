package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class VistaAldeano extends Button{

	private Image vacio;
    private Aldeano aldeano;
    private Image graficoAldeano;
    private Canvas canvas;

    public VistaAldeano(Aldeano aldeano) {
        this.aldeano = aldeano;
        graficoAldeano = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Aldeano/AldeanoS.png");
        vacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/lugarVacio.png");
        canvas = new Canvas();
        canvas.getGraphicsContext2D().drawImage(graficoAldeano, 0, 0);
    }
    
    public int getPosX() {
    	return aldeano.getPosicion().getPosicionX();
    }
    
    public int getPosY() {
    	return aldeano.getPosicion().getPosicionY();
    }
/*
    public void dibujar() {
        canvas.getGraphicsContext2D().drawImage(graficoAldeano, 0, 0);
    }

    public void clean() {
        canvas.getGraphicsContext2D().drawImage(vacio, aldeano.getPosicion().getPosicionX() * 32 , aldeano.getPosicion().getPosicionY() * 32);
    }

    public void update() {
        this.dibujar();
    }
    */
}
