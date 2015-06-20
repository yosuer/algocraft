package fiuba.algo3.algocraft.vista;

import java.io.IOException;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaIElemento extends Imagen {

	public VistaIElemento(IElemento iElemento) throws IOException {
		super(VistaIElemento.class.getResource("/res/"+iElemento.nombre()+".png"), 
													(ObjetoPosicionable)iElemento);
	}

}

//sprites

//atlasses