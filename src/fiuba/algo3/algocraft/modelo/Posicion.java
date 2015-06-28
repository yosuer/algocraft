package fiuba.algo3.algocraft.modelo;

public class Posicion {

	private int x,y,z;
	private IElemento elemento;
	
	public Posicion(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setElemento(IElemento elemento){
		this.elemento = elemento;
	}
	
	public IElemento getElemento(){
		return this.elemento;
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
	
	public String toString(){
		return this.x + "," + this.y + "," + this.z;
	}

	public Posicion Xpp() {
		this.x +=1;
		return this;
	}

	public Posicion Ypp() {
		this.y +=1;
		return this;
	}

	public Posicion ppX() {
		this.x -=1;
		return this;
	}
	
	public Posicion ppY() {
		this.y -=1;
		return this;
	}
	
	public Posicion ppXppY() {
		this.x -=1;
		this.y -=1;
		return this;
	}
	
	public Posicion ppXYpp() {
		this.x -=1;
		this.y +=1;
		return this;
	}
	
	public Posicion XppppY() {
		this.x +=1;
		this.y -=1;
		return this;
	}
	
	public Posicion XppYpp() {
		this.x +=1;
		this.y +=1;
		return this;
	}

}
