package fiuba.algo3.algocraft.modelo;

public class FloatRango {
	
	private float min;
	private float max;
	private float actual;
	
	public FloatRango(float maximo){
		min = 0;
		max = maximo;
		actual = maximo;
	}
	
	public FloatRango(float minimo, float maximo){
		min = minimo;
		max = maximo;
		actual = maximo;
	}
	
	public float val(){
		return actual;
	}
	
	public float disminuir(float n){
		float resto = actual-=n;
		if (actual < min)
			actual = min;
		else 
			resto = 0;
		
		return resto*-1;
	}

	public void aumentar(float n) {
		actual+=n;
		if (actual > max) actual = max;
	}
}
