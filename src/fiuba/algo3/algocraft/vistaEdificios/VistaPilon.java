package fiuba.algo3.algocraft.vistaEdificios;

import java.io.IOException;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.Pilon;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaPilon extends VistaIElemento {

	public VistaPilon(){
		this.elemento = new Pilon();
		this.armarImagen();
	}
	

}
