package fiuba.algo3.algocraft.vista;

import java.awt.Graphics;

import javax.swing.JPanel;

import fiuba.algo3.algocraft.modelo.IElemento;
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

	private VistaIElemento vistaActual;
	private IElemento elementoActual;

	public VistaCasillero(IMapa mapa, int x, int y) {
		this.x = x;
		this.y = y;
		this.mapa = mapa;
		actualizar();
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		try {
			int posX = x - 1;
			int posY = y - 1;
			int tam = 22;

			Graphics grafico = ((SuperficiePanel) superficieDeDibujo)
					.getBuffer();
			grafico.drawImage(vistaActual.getBufferedImage(), tam * posX, tam
					* posY, tam, tam, null);
		} catch (NullPointerException e) {
		}
		actualizar();
	}

	public IElemento getVisible() {
		return elementoActual;
	}

	public VistaIElemento getVistaElementoActual() {
		return vistaActual;
	}

	private void actualizar() {
		elementoActual = mapa.getElemento(x, y, 1);
		if (elementoActual == null)
			elementoActual = mapa.getElemento(x, y, 0);

		vistaActual = VistaIElemento.vistasElementos.get(elementoActual
				.nombre());
	}

}
