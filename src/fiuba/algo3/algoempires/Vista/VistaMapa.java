package fiuba.algo3.algoempires.Vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaMapa extends GridPane{
	
	private int rowNum = 20;
	private int colNum = 20;
	private Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
	public VistaMapa() {
		for (int row = 0; row < rowNum ; row++) {
		    for (int col = 0; col < colNum ; col++) {
		        Canvas rec = new Canvas();
		        rec.setWidth(32);
		        rec.setHeight(32);
		        rec.getGraphicsContext2D().drawImage(pisoVacio, 0, 0);
		        GridPane.setRowIndex(rec, row);
		        GridPane.setColumnIndex(rec, col);
		        this.getChildren().addAll(rec);
		    }
		}		
	}

	public void agregar(VistaAldeano vistaAldeano) {
		this.add(vistaAldeano,vistaAldeano.getPosX(),vistaAldeano.getPosY());
	}
}
