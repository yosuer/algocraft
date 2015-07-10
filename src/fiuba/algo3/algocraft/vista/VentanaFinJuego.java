package fiuba.algo3.algocraft.vista;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fiuba.algo3.algocraft.modelo.Equipo;

public class VentanaFinJuego extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblGanador;
	private JLabel lblPerdedor;
	private Container contenedor;

	public VentanaFinJuego(Equipo ganador) {
		super();
		setTitle("Fin Juego");
		contenedor = getContentPane();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		lblGanador.setText("Ganador " + ganador.getNombre());
		contenedor.add(lblGanador);
	}

}
