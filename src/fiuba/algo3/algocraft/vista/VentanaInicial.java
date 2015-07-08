package fiuba.algo3.algocraft.vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fiuba.algo3.algocraft.Juego;

public class VentanaInicial extends JFrame implements ActionListener {

	private static final long serialVersionUID = -133982114697528815L;

	private Container contenedor;
	private Juego juego;
	JLabel labelTitulo = new JLabel("AlgoCraft");
	JLabel jugador1 = new JLabel("Jugador 1:");
	JLabel jugador2 = new JLabel("Jugador 2:");
	JTextField nombreJ1 = new JTextField(15);
	JTextField nombreJ2 = new JTextField(15);
	JButton botonIniciar = new JButton("Iniciar");
	JButton botonSalir = new JButton("Salir");
	JComboBox razaJug1;
	JComboBox razaJug2;

	int tamX = 400;
	int tamY = 250;

	public VentanaInicial(Juego unJuego) {
		this.juego = unJuego;
		iniciarComponentes();
		setTitle("AlgoCraft");
		setSize(tamX, tamY);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	private void iniciarComponentes() {
		contenedor = getContentPane();
		GridBagLayout gbl = new GridBagLayout();
		contenedor.setLayout(gbl);
		botonIniciar.addActionListener(this);
		botonSalir.addActionListener(this);
		razaJug1 = new JComboBox(juego.getRazas());
		razaJug2 = new JComboBox(juego.getRazas());

		GridBagConstraints config = new GridBagConstraints();
		config.insets = new Insets(20, 10, 10, 10);

		config.gridx = 1;
		config.gridy = 2;
		contenedor.add(jugador1, config);

		config.gridx = 2;
		config.gridy = 2;
		contenedor.add(nombreJ1, config);

		config.gridx = 3;
		config.gridy = 2;
		// contenedor.add(razaJug1, config);

		config.gridx = 1;
		config.gridy = 3;
		contenedor.add(jugador2, config);

		config.gridx = 2;
		config.gridy = 3;
		contenedor.add(nombreJ2, config);

		config.gridx = 3;
		config.gridy = 3;
		// contenedor.add(razaJug2, config);

		config.gridx = 1;
		config.gridy = 5;
		contenedor.add(botonIniciar, config);

		config.gridx = 3;
		config.gridy = 5;
		contenedor.add(botonSalir, config);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Iniciar") {
			String nombreJug1 = nombreJ1.getText();
			String nombreJug2 = nombreJ2.getText();

			if (!nombreJug1.equals(nombreJug2)) {
				juego.agregarJugadores(nombreJ1.getText(), nombreJ2.getText(),
						(String) razaJug1.getSelectedItem(),
						(String) razaJug2.getSelectedItem());
				juego.comenzar();
			} else {
				System.out.println("Nombre invalido");
			}
		}
	}
}
