package fiuba.algo3.algoempires.Model;

import junit.framework.Assert;
import org.junit.Test;

public class AlgoEmpiresTest {

	@Test
	public void crearTableroLoInicializaVacio(){
		AlgoEmpires algoEmpires = new AlgoEmpires();
		algoEmpires.inicializarMapa();
        Assert.assertEquals(algoEmpires.elMapaEstaVacio(), true);
	}
	
}
