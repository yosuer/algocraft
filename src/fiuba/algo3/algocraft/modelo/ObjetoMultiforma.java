package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class ObjetoMultiforma implements ObjetoVivo, ObjetoPosicionable {

	private int estado;
	private int x;
	private int y;
	private int X_INICIAL = 45;
	private int Y_INICIAL = 45;

	public ObjetoMultiforma() {
		this.x = this.X_INICIAL;
		this.y = this.Y_INICIAL;
	}
	@Override
	public void vivir() {
		this.estado++;
		
		if(this.estado > 3) {
			this.estado = 0;
		}
		if(this.x > this.X_INICIAL) {
			this.x--;
		}
		if(this.x < this.X_INICIAL) {
			this.x++;
		}
		if(this.y > this.Y_INICIAL) {
			this.y--;
		}
		if(this.y < this.Y_INICIAL) {
			this.y++;
		}
	}
	
	public int getEstado() {
		return this.estado;
	}

	public void mutar() {
		this.x += 60;
		this.y += 60;
	}
	
	public void inmutar() {
		this.x += 150;
		this.y += 40;
	}

	public void moverA(int nuevoX, int nuevoY) {
		this.x = nuevoX;
		this.y = nuevoY;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
