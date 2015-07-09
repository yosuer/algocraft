package fiuba.algo3.algocraft.vistaUnidades;

import fiuba.algo3.algocraft.vista.VistaUnidad;



import fiuba.algo3.algocraft.controlador.BotonMover;
import fiuba.algo3.algocraft.controlador.acciones.Mover;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.unidades.AlucinacionUnidad;
import fiuba.algo3.algocraft.modelo.unidades.Scout;
import fiuba.algo3.algocraft.vista.VistaIElemento;


public class VistaAlucinacionUnidad extends VistaUnidad {
	
	public VistaAlucinacionUnidad(){
		this.elemento = new AlucinacionUnidad(new AltoTemplario());
		this.armarImagen();
	}
}
