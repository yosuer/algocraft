package fiuba.algo3.algocraft.vistaUnidades;

import java.io.IOException;


import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.*;
import fiuba.algo3.algocraft.controlador.acciones.*;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.unidades.AltoTemplario;

import fiuba.algo3.algocraft.modelo.unidades.Reina;
import fiuba.algo3.algocraft.vista.VistaUnidad;

public class VistaReina extends VistaUnidad {


	JButton btnInfestarUnidad = new BotonMagiaConUnidad("Infestar Unidad",new LanzarMagiaAUnidad());
	JButton btnLanzarRed = new BotonMagiaConPosicion("Lanzar Red",new LanzarMagiaAPosicion()); 
	
	public VistaReina(){
		this.elemento = new Reina();
		this.armarImagen();
		
		this.acciones.add(btnInfestarUnidad);
		this.acciones.add(btnLanzarRed);
		
	}

}
