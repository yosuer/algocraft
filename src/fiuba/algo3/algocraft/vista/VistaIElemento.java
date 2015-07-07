package fiuba.algo3.algocraft.vista;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public abstract class VistaIElemento {

	protected IElemento elemento;
	protected Imagen imagen;
	protected Collection<JButton> acciones = new LinkedList<JButton>();;

	public static HashMap<String, VistaIElemento> vistasElementos = new HashMap<String, VistaIElemento>();

	protected void armarImagen() {
		imagen = new Imagen(getRuta(), (ObjetoPosicionable) elemento);
	}

	public static VistaIElemento getVista(String nombre) {
		return vistasElementos.get(nombre);
	}

	protected void setModelo(IElemento elemento) {
		this.elemento = elemento;
	}

	protected URL getRuta() {
		return VistaIElemento.class.getResource("/res/" + elemento.nombre()
				+ ".png");
	}

	protected Collection<JButton> getBotones() {
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