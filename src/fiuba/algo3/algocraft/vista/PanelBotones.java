package fiuba.algo3.algocraft.vista;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {

	JButton btnIniciar;
	JButton btnSalir;

	public PanelBotones() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		btnIniciar = new JButton("Iniciar");
		btnSalir = new JButton("Salir");

		add(btnIniciar);
		add(btnSalir);
	}
}
