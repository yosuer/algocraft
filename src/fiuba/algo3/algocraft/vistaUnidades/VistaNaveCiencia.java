package fiuba.algo3.algocraft.vistaUnidades;

import java.io.IOException;


import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.*;
import fiuba.algo3.algocraft.controlador.acciones.*;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.unidades.AltoTemplario;

import fiuba.algo3.algocraft.modelo.unidades.NaveCiencia;
import fiuba.algo3.algocraft.vista.VistaUnidad;

public class VistaNaveCiencia extends VistaUnidad {

	JButton btnLanzarRadiacion = new BotonMagiaConUnidad("Lanzar Radiacion",new LanzarMagiaAUnidad());
	JButton btnLanzarEMP = new BotonMagiaConPosicion("Lanzar Misil EMP",new LanzarMagiaAPosicion());
	
	public VistaNaveCiencia(){
		this.elemento = new NaveCiencia();
		this.armarImagen();
		
		this.acciones.add(btnLanzarRadiacion);
		this.acciones.add(btnLanzarEMP);
	}

}
