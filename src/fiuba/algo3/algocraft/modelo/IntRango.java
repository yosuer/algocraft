package fiuba.algo3.algocraft.modelo;

public class IntRango {

	private int min;
	private int max;
	private int actual;
	
	public IntRango(int maximo){
		min = 0;
		max = maximo;
		actual = maximo;
	}
	
	public IntRango(int minimo, int maximo){
		min = minimo;
		max = maximo;
		actual = maximo;
	}
	
	public int val(){
		return actual;
	}
	
	public int disminuir(int n){
		int resto = actual-=n;
		if (actual < min)
			actual = min;
		else 
			resto = 0;
		
		return resto*-1;
	}

	public void aumentar(int n) {
		actual+=n;
		if (actual > max) actual = max;
	}
}
