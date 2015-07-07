package fiuba.algo3.algocraft.vistaEdificios;

import java.io.IOException;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.Asimilador;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaAsimilador extends VistaIElemento{

	public VistaAsimilador(){
		this.elemento = new Asimilador();
		this.armarImagen();
	}

}
