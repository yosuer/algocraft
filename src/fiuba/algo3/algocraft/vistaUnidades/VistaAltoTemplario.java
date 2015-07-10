package fiuba.algo3.algocraft.vistaUnidades;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.BotonMagiaConUnidad;
import fiuba.algo3.algocraft.controlador.acciones.LanzarMagiaAPosicion;
import fiuba.algo3.algocraft.controlador.acciones.LanzarMagiaAUnidad;
import fiuba.algo3.algocraft.modelo.unidades.AltoTemplario;
import fiuba.algo3.algocraft.vista.VistaUnidad;

public class VistaAltoTemplario extends VistaUnidad {

	JButton btnCrearAlucinacion = new BotonMagiaConUnidad("Alucinacion",
			new LanzarMagiaAUnidad());
	JButton btnLanzarTormenta = new BotonMagiaConUnidad("Tormenta",
			new LanzarMagiaAPosicion());

	public VistaAltoTemplario() {
		this.elemento = new AltoTemplario();
		this.armarImagen();

		this.acciones.add(btnCrearAlucinacion);
		this.acciones.add(btnLanzarTormenta);

	}
}
