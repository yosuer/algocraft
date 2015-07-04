package fiuba.algo3.algocraft.vista;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaIElemento extends Imagen {

	protected IElemento elemento;
	protected Imagen imagen;
	protected Posicion posicion;
	protected Collection<JButton> acciones;

	public static HashMap<String, VistaIElemento> vistasIElementos = new HashMap<String, VistaIElemento>();

	public VistaIElemento(IElemento e) {
		super(getRuta(e), (ObjetoPosicionable) e);
		imagen = new Imagen(getRuta(e), (ObjetoPosicionable) e);
		elemento = e;
		acciones = new LinkedList<JButton>();
	}

	public static URL getRuta(IElemento e) {
		return VistaIElemento.class.getResource("/res/" + e.nombre() + ".png");
	}

	public Collection<JButton> getBotones() {
		return acciones;
	}

	public BufferedImage getBufferedImage() {
		return imagen.getImage();
	}

	public IElemento getElemento() {
		return elemento;
	}

}

// sprites

// atlasses