package fiuba.algo3.algocraft.vistaEdificios;

import java.io.IOException;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.NexoMineral;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaNexoMineral extends VistaIElemento{

	public VistaNexoMineral(){
		this.elemento = new NexoMineral();
		this.armarImagen();
	}

}
