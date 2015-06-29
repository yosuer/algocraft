package fiuba.algo3.algocraft.vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.controlador.Boton;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = -133982114697528815L;

	private Container contenedor;
	JLabel labelTitulo = new JLabel("AlgoCraft");
	JLabel jugador1 = new JLabel("Jugador 1:");
	JLabel jugador2 = new JLabel("Jugador 2:");
	JTextField nombreJ1 = new JTextField(15);
	JTextField nombreJ2 = new JTextField(15);
	JButton botonIniciarPartida = new Boton("Iniciar", this);
	JButton botonSalir = new Boton("Salir", this);

	int tamX = 400;
	int tamY = 250;
	private Juego juego;

	public VentanaPrincipal(Juego unJuego) {
		iniciarComponentes();
		this.juego = unJuego;
		setTitle("AlgoCraft");
		setSize(tamX, tamY);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	private void iniciarComponentes() {
		contenedor = getContentPane();
		GridBagLayout gbl = new GridBagLayout();
		contenedor.setLayout(gbl);

		GridBagConstraints config = new GridBagConstraints();
		config.insets = new Insets(20, 10, 10, 10);

		config.gridx = 1;
		config.gridy = 2;
		contenedor.add(jugador1, config);

		config.gridx = 2;
		config.gridy = 2;
		contenedor.add(nombreJ1, config);

		config.gridx = 1;
		config.gridy = 3;
		contenedor.add(jugador2, config);

		config.gridx = 2;
		config.gridy = 3;
		contenedor.add(nombreJ2, config);

		config.gridx = 1;
		config.gridy = 5;
		contenedor.add(botonIniciarPartida, config);

		config.gridx = 2;
		config.gridy = 5;
		contenedor.add(botonSalir, config);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Iniciar") {
			String nombreJug1 = nombreJ1.getText();
			String nombreJug2 = nombreJ2.getText();

			if (!nombreJug1.equals(nombreJug2)) {
				juego.agregarJugadores(nombreJ1.getText(), nombreJ2.getText());
				juego.comenzar();
			} else {
				System.out.println("Nombre invalido");
			}
		}
	}
}
