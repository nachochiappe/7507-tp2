package pruebas;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PruebasGridPane extends GridPane{
	
	
	private int rowNum = 20;
	private int colNum = 20;

	public PruebasGridPane() {
		for (int row = 0; row < rowNum ; row++) {
		    for (int col = 0; col < colNum ; col++) {
		        Canvas rec = new Canvas();
		        rec.setWidth(32);
		        rec.setHeight(32);
		        rec.getGraphicsContext2D();
		        this.setRowIndex(rec, row);
		        this.setColumnIndex(rec, col);
		        this.getChildren().addAll(rec);
		    }
		}
		
	}
}
