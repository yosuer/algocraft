package fiuba.algo3.algocraft.vista;

import java.io.IOException;
import java.net.URL;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaIElemento extends Imagen {

	protected IElemento elemento;
	private final static String raiz = "/res/";
	private final static String ext = ".png";
	
	public VistaIElemento(IElemento e) throws IOException {
		super(getRuta(e), (ObjetoPosicionable)e);
		elemento = e;
	}
	
	public static URL getRuta(IElemento e){
		return VistaIElemento.class.getResource(raiz+e.nombre()+ext);
	}

}

//sprites

//atlasses