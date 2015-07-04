package fiuba.algo3.algocraft.vista.vistasModelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaBarraca extends VistaIElemento implements ActionListener {

	public JButton btnCrearMarine = new JButton("CrearMarine");

	public VistaBarraca() {
		elemento = new Barraca();
		armarImagen();
		btnCrearMarine.addActionListener(this);
		acciones.add(btnCrearMarine);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((Barraca) elemento).crearMarine();
	}

}
