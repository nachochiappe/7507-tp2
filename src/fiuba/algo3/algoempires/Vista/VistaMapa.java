package fiuba.algo3.algoempires.Vista;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaMapa extends GridPane{
	
	private int rowNum = 20;
	private int colNum = 20;
	public VistaMapa() {
		for (int row = 0; row < rowNum ; row++) {
		    for (int col = 0; col < colNum ; col++) {
		        VistaLugarVacio rec = new VistaLugarVacio();
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
