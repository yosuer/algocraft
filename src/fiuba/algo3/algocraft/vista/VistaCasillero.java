package fiuba.algo3.algocraft.vista;

import java.awt.Graphics;

import javax.swing.JPanel;

import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VistaCasillero extends JPanel implements ObjetoDibujable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private IMapa mapa;

	VistaIElemento elementoAereo;
	VistaIElemento elementoTerrestre;

	public VistaCasillero(IMapa mapa, int x, int y) {
		this.x = x;
		this.y = y;
		this.mapa = mapa;
		// if (elemento.getNivel() == 0)
		// elementoAereo = new VistaIElemento(mapa.getElemento(x, y, 1));
		elementoTerrestre = new VistaIElemento(mapa.getElemento(x, y, 0));
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		try {
			int posX = x - 1;
			int posY = y - 1;
			int tam = 22;

			Graphics grafico = ((SuperficiePanel) superficieDeDibujo)
					.getBuffer();
			grafico.drawImage(elementoTerrestre.getBufferedImage(), tam * posX,
					tam * posY, tam, tam, null);
			// System.out.println("DC " + x + "," + y);
		} catch (NullPointerException e) {
			// System.out.println("NullPointer");
		}
	}

	public VistaIElemento getVisible() {
		return elementoTerrestre;
	}

}
