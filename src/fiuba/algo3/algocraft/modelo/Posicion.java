package fiuba.algo3.algocraft.modelo;

public class Posicion {

	private int x,y,z;
	
	public Posicion(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int x() {
		return this.x;
	}

	public int y() {
		return this.y;
	}
	
	public int z() {
		return this.z;
	}
	
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if (!(o instanceof Posicion)) return false;
		
		Posicion p = (Posicion)o;
		return (p.x() == this.x) & 
				(p.y() == this.y) &
				(p.z() == this.z);
		
	}

}
