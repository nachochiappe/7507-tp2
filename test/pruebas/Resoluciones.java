package pruebas;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Resoluciones {
	
	public static void main(String[] args){
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("Tu resoluci�n es de " + screenSize.width + "x" + screenSize.height);
	}
}
