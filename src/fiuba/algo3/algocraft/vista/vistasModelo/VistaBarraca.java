package fiuba.algo3.algocraft.vista.vistasModelo;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaBarraca extends VistaIElemento {

	public JButton btnCrearMarine = new JButton("CrearMarine");

	public VistaBarraca() {
		elemento = new Barraca();
		armarImagen();
		acciones.add(btnCrearMarine);
	}
}
