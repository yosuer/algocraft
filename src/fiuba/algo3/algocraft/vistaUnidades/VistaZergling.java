package fiuba.algo3.algocraft.vistaUnidades;

import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.BotonMover;
import fiuba.algo3.algocraft.controlador.acciones.Mover;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.unidades.Zerling;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaZergling extends VistaIElemento {
	
	JButton btnMover;

	public VistaZergling(){
		this.elemento = new Zerling();
		this.armarImagen();
		
		this.btnMover = new BotonMover("Mover", new Mover());
		this.acciones.add(btnMover);
	}

	protected void setModelo(IElemento elemento) {
		this.elemento = elemento;
	}

}
