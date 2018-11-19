package pruebas;

import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class PruebasGenericas {
	 @Test
	public void pruebaPosiciones() {
		Posicion posicion1 = new Posicion(1,2);
		Assert.assertTrue(posicion1.dentroDe(25, 2));
	}
	 
	 @Test
	public void pruebaPosiciones2() {
		Posicion posicion1 = new Posicion(1,2);
		Assert.assertTrue(posicion1.dentroDe(1, 247));
	}
	 @Test
	public void pruebaPosicionesEnRango() {
		Posicion posicion1 = new Posicion(1,2);
		Posicion posicion2 = new Posicion(0,2);
		Assert.assertTrue(posicion1.estaEnRango(posicion2,1));
	}
	 
	 @Test
	public void pruebaPosicionesFueraDeRango() {
		Posicion posicion1 = new Posicion(1,2);
		Posicion posicion2 = new Posicion(0,4);
		Assert.assertTrue(!(posicion1.estaEnRango(posicion2,1)));
	}
	 
}
