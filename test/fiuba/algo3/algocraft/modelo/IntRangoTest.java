package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class IntRangoTest {
	
	@Test
	public void test01_DisminuirYAumentarValorARango(){
		IntRango num = new IntRango(100);
		Assert.assertEquals(100, num.valor());
		
		num.disminuir(50);
		Assert.assertEquals(50, num.valor());
		
		num.aumentar(12);
		Assert.assertEquals(62, num.valor());
	}
	
	@Test
	public void test02_ElValorNoEsMayorQueElMaximo(){
		IntRango num = new IntRango(60);
		num.aumentar(10);
		
		Assert.assertEquals(60, num.valor());
	}
	
	@Test
	public void test03_ElValorNoEsMenorQueElMinimo(){
		IntRango num = new IntRango(60);
		num.disminuir(45);
		num.disminuir(26);
		
		Assert.assertEquals(0, num.valor());
	}
	
	@Test
	public void test04_DisminuirDevuelveElResto(){
		IntRango num = new IntRango(20);
		
		Assert.assertEquals(0, num.disminuir(15));
		Assert.assertEquals(12, num.disminuir(17));
		Assert.assertEquals(0, num.valor());
	}
	
}
