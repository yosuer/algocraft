package fiuba.algo3.algocraft;

public class Posicion {

	private int x,y;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int posX() {
		return this.x;
	}

	public int posY() {
		return this.y;
	}
	
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if (!(o instanceof Posicion)) return false;
		
		Posicion p = (Posicion)o;
		return (p.posX() == this.x) & (p.posY() == this.y);
		
	}

}
