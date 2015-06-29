package fiuba.algo3.algocraft.vista;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaIElemento extends Imagen {

	protected VistaMapa mapa;
	protected IElemento elemento;
	protected Imagen imagen;
	protected Posicion posicion;
	protected Collection<JButton> botones;

	public VistaIElemento(VistaMapa mapa, IElemento e) throws IOException {
		super(getRuta(e), (ObjetoPosicionable) e);
		this.mapa = mapa;
		elemento = e;
	}

	public static URL getRuta(IElemento e) {
		return VistaIElemento.class.getResource("/res/" + e.nombre() + ".png");
	}

	public Collection<JButton> getBotones() {
		return new LinkedList<JButton>();
	}

}

// sprites

// atlasses