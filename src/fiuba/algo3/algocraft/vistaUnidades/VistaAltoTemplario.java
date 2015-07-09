package fiuba.algo3.algocraft.vistaUnidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.BotonMagiaConUnidad;
import fiuba.algo3.algocraft.controlador.BotonMover;
import fiuba.algo3.algocraft.controlador.acciones.LanzarMagiaAPosicion;
import fiuba.algo3.algocraft.controlador.acciones.LanzarMagiaAUnidad;
import fiuba.algo3.algocraft.controlador.acciones.Mover;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.unidades.AltoTemplario;
import fiuba.algo3.algocraft.vista.VistaUnidad;

public class VistaAltoTemplario extends VistaUnidad {

	JButton btnCrearAlucinacion = new BotonMagiaConUnidad("Crear Alucinacion",new LanzarMagiaAUnidad());
	JButton btnLanzarTormenta = new BotonMagiaConUnidad("Lanzar Tormenta Psionica",new LanzarMagiaAPosicion()); 
	
	public VistaAltoTemplario(){
		this.elemento = new AltoTemplario();
		this.armarImagen();
		
		this.acciones.add(btnCrearAlucinacion);
		this.acciones.add(btnLanzarTormenta);

	}
}
